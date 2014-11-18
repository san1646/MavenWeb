package main.java.com.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.plm.dao.EmployeeDao;
import main.java.com.plm.dao.Proj_EmpDao;
import main.java.com.plm.model.Proj_Emp;
import main.java.com.plm.service.Proj_EmpService;

@Service
@Transactional
public class Proj_EmpServiceImpl implements Proj_EmpService {

	@Autowired
	private Proj_EmpDao proj_EmpDao;
	
	/*BUG FIX - UnresolvedEntityInsertActions
	 * Without the method level @Transactional annotation, we get UnresolvedEntityInsertActions.
	 * Adding it, the issue was resolved. 
	 * Reason could that the class level annotation might not propogate to the concerned method.	 * 
	 * */
	@Transactional
	public Integer associateProj_Emp(Proj_Emp proj_Emp) {
		// TODO Auto-generated method stub
		return proj_EmpDao.associateProj_Emp(proj_Emp);
	}

	public List<Proj_Emp> getProj_EmpAssociations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<Proj_Emp> getEmployeesForProject(Integer projectId) {
		// TODO Auto-generated method stub
		return proj_EmpDao.getEmployeesForProject(projectId);
	}

	public List<Proj_Emp> getProjectsForEmployees(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
