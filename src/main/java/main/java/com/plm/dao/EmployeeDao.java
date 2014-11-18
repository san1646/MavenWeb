package main.java.com.plm.dao;

import java.util.List;

import main.java.com.plm.model.Employee;

public interface EmployeeDao {
	Integer insertEmployee(Employee employee);
	List<Employee> getEmployees();
	Employee getEmployee(Integer employeeId);
	List<Employee> getEmployees(List<Integer> employeeIdList);
}
