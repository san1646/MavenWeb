package main.java.com.plm.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.plm.dao.ProjectDao;
import main.java.com.plm.model.KnightedWBSRate;
import main.java.com.plm.model.Project;

@Repository
@org.springframework.transaction.annotation.Transactional
public class ProjectDaoImpl implements ProjectDao{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Transactional
	public Project getProjectById(Integer projectId) {
		// TODO Auto-generated method stub
		sessionFactory.getCache().evictEntityRegion(Project.class);
		
		Query query = getCurrentSession().createQuery("from Project where projectId = :projectId");
		query.setParameter("projectId", projectId);
		List<Project> projectList =(List<Project>) query.list();  
		Project project  = null;
		if(projectList.size()!=0){
			project = projectList.get(0);
			
		}
		return project;
		
	}
	
	public Integer insertProject(Project project) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(project);
		return project.getProjectId();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		
		/*Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Project.class);
		criteria.setMaxResults(50);
		return criteria.list();*/
		
		
		Query query = getCurrentSession().createQuery("from Project");
		List<Project> projectList = (List<Project>) query.list();
		return projectList;
		
		/*return null;*/
	}
	
	
	public Integer updateProjectStatus(Integer projectId, int projectStatusId) {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().createQuery("update Project set statusId = :projectStatusId where projectId = :projectId");
		query.setParameter("projectStatusId", projectStatusId);
		query.setParameter("projectId", projectId);
		return query.executeUpdate();
	}
}
