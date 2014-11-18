package main.java.com.plm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.plm.dao.Proj_EmpDao;
import main.java.com.plm.model.Proj_Emp;
import main.java.com.plm.model.Project;

@Repository
@org.springframework.transaction.annotation.Transactional
public class Proj_EmpDaoImpl implements Proj_EmpDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer associateProj_Emp(Proj_Emp proj_Emp) {
		// TODO Auto-generated method stub
		proj_Emp =  (Proj_Emp) sessionFactory.getCurrentSession().merge(proj_Emp);
		
		return proj_Emp.getProj_EmpId().getProject_projectId();
		
	}

	public List<Proj_Emp> getProj_EmpAssociations() {
		// TODO Auto-generated method stub
		return null;
	}

	@org.springframework.transaction.annotation.Transactional
	public List<Proj_Emp> getEmployeesForProject(Integer projectId) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Proj_Emp where PROJECT_PROJECTID = :projectId");
		query.setParameter("projectId", projectId);
		
		@SuppressWarnings("unchecked")
		List<Proj_Emp> proj_EmpList =(List<Proj_Emp>) query.list();  
		
		return proj_EmpList;
	}

	public List<Proj_Emp> getProjectsForEmployees(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
