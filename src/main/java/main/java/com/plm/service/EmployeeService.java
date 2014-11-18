package main.java.com.plm.service;

import java.util.List;

import main.java.com.plm.model.Employee;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService  {
	Integer insertEmployee(Employee employee);
	List<Employee> getEmployees();
	Employee getEmployee(Integer employeeId);
	List<Employee> getEmployees(List<Integer> employeeIdList);
}
