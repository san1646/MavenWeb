package main.java.com.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.plm.dao.EmployeeDao;
import main.java.com.plm.dao.TechnologyDao;
import main.java.com.plm.model.Employee;
import main.java.com.plm.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public Integer insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.insertEmployee(employee);
	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getEmployees();
	}

	public Employee getEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(employeeId);
	}

	public List<Employee> getEmployees(List<Integer> employeeIdList) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployees(employeeIdList);
	}

}
