package main.java.com.plm.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import main.java.com.plm.dao.TechnologyDao;
import main.java.com.plm.model.KnightedWBSRate;
import main.java.com.plm.model.KnightedWBSTechnology;
import main.java.com.plm.model.KnightedWbsComplete;
import main.java.com.plm.model.Project;
import main.java.com.plm.model.ProjectKWBS;
import main.java.com.plm.model.ProjectKWBSId;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@org.springframework.transaction.annotation.Transactional
public class TechnologyDaoImpl implements TechnologyDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void insertKnightedWBS(KnightedWBSTechnology knightedWBSTechnology) {
		// TODO Auto-generated method stub
		getCurrentSession().save(knightedWBSTechnology);

	}

	@SuppressWarnings("unchecked")
	public List<KnightedWBSTechnology> getKnightedWBS() {
		// TODO Auto-generated method stub

		//To clear the L1 cache
		/*
		 * For the second-level cache, there are methods defined on SessionFactory for evicting the cached state of an instance, entire class, collection instance or entire collection role.

			sessionFactory.evict(Cat.class, catId); //evict a particular Cat
			sessionFactory.evict(Cat.class);  //evict all Cats
			sessionFactory.evictCollection("Cat.kittens", catId); //evict a particular 
            //collection of kittens
			sessionFactory.evictCollection("Cat.kittens"); //evict all kitten collections
		 * */
		sessionFactory.getCache().evictEntityRegion(KnightedWBSTechnology.class);
		
		Query query = getCurrentSession().createQuery("from KnightedWBSTechnology");
		List<KnightedWBSTechnology> knightedWBSList = (List<KnightedWBSTechnology>) query.list();
		return knightedWBSList;
	}
	
	public int updateKnightedWBS(KnightedWBSTechnology knightedWBSTechnology) {
		// TODO Auto-generated method stub
		//This is the proper way to update.
		//Get the Entity object by Id. Modify it, and then save it. Since, we do not have Id, this cannot be done
		/*KnightedWBSTechnology k = (KnightedWBSTechnology)getCurrentSession().get(KnightedWBSTechnology.class, knightedWBSTechnology.getTaskNumber());
		k.setHours(knightedWBSTechnology.getHours());
		getCurrentSession().save(k);
		return k.getKnightedWbsId();
		*/		
				
		Query query = getCurrentSession().createQuery("update KnightedWBSTechnology set HOURS = :hours, TASKNAME = :taskName where TASKNUMBER = :taskNumber");
				query.setParameter("hours", knightedWBSTechnology.getHours());
				query.setParameter("taskNumber", knightedWBSTechnology.getTaskNumber());
				query.setParameter("taskName", knightedWBSTechnology.getTaskName());
				getCurrentSession().clear();
				int result = query.executeUpdate();
				
		return result;
	}
	
	//Knighted Rate methods
	/*
	 * This method queries the database for Knighted Rates
	 * */
	public List<KnightedWBSRate> getKnightedRate() {
		// TODO Auto-generated method stub
		sessionFactory.getCache().evictEntityRegion(KnightedWBSRate.class);
		
		Query query = getCurrentSession().createQuery("from KnightedWBSRate");
		@SuppressWarnings("unchecked")
		List<KnightedWBSRate> knightedWBSRateList = (List<KnightedWBSRate>) query.list();
		return knightedWBSRateList;
	}
	
	/*This method updates the Knighted rates for a given task number
	 * */
	public int insertKnightedRate(KnightedWBSRate knightedWBSRate) {
		// TODO Auto-generated method stub
		
		Query query = getCurrentSession().createQuery("update KnightedWBSRate set RATE = :rate where TASKNUMBER = :taskNumber");
		query.setParameter("rate", knightedWBSRate.getRate());
		query.setParameter("taskNumber", knightedWBSRate.getTaskNumber());
		getCurrentSession().clear();
		int result = query.executeUpdate();
		
		return result;
	}
	
	public ProjectKWBSId insertProjectKWBS(ProjectKWBS projectKWBS) {
		// TODO Auto-generated method stub
		getCurrentSession().clear();
		ProjectKWBSId projectKWBSReturn = (ProjectKWBSId) getCurrentSession().save(projectKWBS);
		
		return projectKWBSReturn;
	}
	
	public List<ProjectKWBS> getProjectKWBS() {
		// TODO Auto-generated method stub
		sessionFactory.getCache().evictEntityRegion(ProjectKWBS.class);
		
		Query query = getCurrentSession().createQuery("from ProjectKWBS");
		List<ProjectKWBS> ProjectKWBSList = (List<ProjectKWBS>) query.list();
		return ProjectKWBSList;
	}
	
	@Transactional(readOnly=true)
	public List<ProjectKWBS> getProjectKWBS(Integer projectId) {
		// TODO Auto-generated method stub
		sessionFactory.getCache().evictEntityRegion(ProjectKWBS.class);
		
		Query query = getCurrentSession().createQuery("from ProjectKWBS where projectKWBSId.projectId = :projectId ");
		query.setParameter("projectId", projectId);
		List<ProjectKWBS> projectKWBSList = (List<ProjectKWBS>) query.list();
		return projectKWBSList;
	}
	
	
	/* (non-Javadoc)
	 * @see main.java.com.plm.dao.TechnologyDao#mergeProjectKWBS(main.java.com.plm.model.ProjectKWBS, java.lang.String, java.lang.String)
	 * This method is used to save the Knighted work break down structure. Project_KWBS is the gerund of Project and KnightedWBS. Each entry 
	 * is a link between ProjectId, KnightedWbsId. 
	 * Here we call a stored function to either update (if existing) or insert the entry.
	 */
	@Transactional
	public void mergeProjectKWBS(final ProjectKWBS kwbs, final String taskNumber, String hours) {
		// TODO Auto-generated method stub
		/*java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
	    String sdf = formatter.format(utilDate);
	    
	    
		Query query = getCurrentSession().createSQLQuery(
				"CALL SP_KN_KNIGHTEDWBS(:in_PROJECTID, :in_TASKNUMBER ,:in_HOURS ,:in_NOTEDESCRIPTION ,:in_USERID ,:in_TIMESTAMP, :p_varKnightedId, :p_knightedRate)")
				.addEntity(ProjectKWBS.class)
				.setParameter("in_PROJECTID", kwbs.projectKWBSId.getProjectId())
				.setParameter("in_TASKNUMBER", taskNumber"61.1")
				.setParameter("in_HOURS", hours"9.88")
				.setParameter("in_NOTEDESCRIPTION", kwbs.getNoteDescription()"direct from DaoImpl")
				.setParameter("in_USERID", kwbs.getUserId()"temp")
				.setParameter("in_TIMESTAMP", sdf)
				.setParameter("p_knightedRate", "")
				.setParameter("p_varKnightedId", 0)
				;
			 
		
			List result = query.list();*/
			
			Work work = new Work() {
				  public void execute(Connection connection) throws SQLException {
					    CallableStatement call = 
					    		connection.prepareCall("{ ? = call SF_KN_KNIGHTEDWBS(?,?,?,?,?,?) }");
					    call.registerOutParameter( 1, Types.VARCHAR ); // or whatever it is
					    call.setInt(2, kwbs.getProjectKWBSId().getProjectId());//ProjectId
					    call.setString(3, taskNumber);//TaskNumber
					    
					    /* debugging*/
					    String tempTaskNumber = taskNumber;
					    String tempHours = kwbs.getHours();
					    
					    /* debugging */
					    
					    call.setString(4, kwbs.getHours() );//Hours
					    call.setString(5, kwbs.getNoteDescription());//Note
					    call.setString(6, kwbs.getUserId());//UserId
					    
					    java.util.Date today = new java.util.Date();
					    call.setDate(7, new java.sql.Date(today.getTime()));//Timestamp(Date)
					    
					    call.execute();
					    int result = call.getInt(1); // propagate this back to enclosing class
					  }
					};
					try{
						getCurrentSession().doWork(work);
					}catch(Exception e){
						return;
					}
	}
	

	public Float getKnightedWbsServiceTotalHours(String serviceLevel, Integer projectId) {
		// TODO Auto-generated method stub
	// TODO Auto-generated method stub
			sessionFactory.getCache().evictEntityRegion(ProjectKWBS.class);
			/*Achtung! - 
			 * Do not modify the following query. Even spaces may cause it to fail.*/
			
			String sqlQuery = "select SUM(hours) from project_kwbs" 
												+ " where KN_KNIGHTEDWBS_KNIGHTEDWBSID in"
												+"("
												+"select KNIGHTEDWBSID from kn_knightedwbs where TASKNUMBER like '"+serviceLevel+"%"
												+"')"
												+"and PROJECT_PROJECTID =  "+projectId.toString();
			
			Query query = getCurrentSession().createSQLQuery(sqlQuery);
			
			List totalHours;
			try{
				
			totalHours = (List) query.list();
			return Float.parseFloat(totalHours.get(0).toString());

			}catch(NullPointerException npe){
				return new Float(0);
			}
			catch(Exception e){
					return new Float(0);
			}
			
	}


	public List<KnightedWbsComplete> getKnightedWbsComplete() {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().createQuery("from KnightedWbsComplete");
		List<KnightedWbsComplete> knightedWbsComplete = (List<KnightedWbsComplete>) query.list();

		return knightedWbsComplete;
	}

}
