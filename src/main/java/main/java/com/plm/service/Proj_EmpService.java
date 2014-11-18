package main.java.com.plm.service;

import java.util.List;
import org.springframework.stereotype.Service;
import main.java.com.plm.model.Proj_Emp;

@Service
public interface Proj_EmpService {

	Integer associateProj_Emp(Proj_Emp proj_Emp);
	List<Proj_Emp> getProj_EmpAssociations();
	List<Proj_Emp> getEmployeesForProject(Integer projectId);
	List<Proj_Emp> getProjectsForEmployees(Integer employeeId);
	
}
