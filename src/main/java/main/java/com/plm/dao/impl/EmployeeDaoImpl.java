package main.java.com.plm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.plm.dao.EmployeeDao;
import main.java.com.plm.model.Employee;
import main.java.com.plm.model.Project;

@Repository
@org.springframework.transaction.annotation.Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Integer insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory.getCurrentSession().save(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().createQuery("from Employee");
		return (List<Employee>) query.list();
	}

	public Employee getEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@org.springframework.transaction.annotation.Transactional
	public List<Employee> getEmployees(List<Integer> employeeIdList) {
		// TODO Auto-generated method stub
		Query query = getCurrentSession().createQuery("from Employee e where e.employeeId IN :employeeIdList")
			    .setParameterList("employeeIdList", employeeIdList);
		
		@SuppressWarnings("unchecked")
		List<Employee> employeeList = query.list();
		
		return employeeList;
	}

}
