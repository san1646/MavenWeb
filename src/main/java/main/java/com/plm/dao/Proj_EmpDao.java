package main.java.com.plm.dao;

import java.util.List;

import main.java.com.plm.model.Proj_Emp;

public interface Proj_EmpDao {
	Integer associateProj_Emp(Proj_Emp proj_Emp);
	List<Proj_Emp> getProj_EmpAssociations();
	List<Proj_Emp> getEmployeesForProject(Integer projectId);
	List<Proj_Emp> getProjectsForEmployees(Integer employeeId);
}
