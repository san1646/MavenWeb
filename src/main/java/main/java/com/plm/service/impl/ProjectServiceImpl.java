package main.java.com.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.plm.dao.ProjectDao;
import main.java.com.plm.dao.impl.ProjectDaoImpl;
import main.java.com.plm.form.Contact;
import main.java.com.plm.model.Project;
import main.java.com.plm.service.ProjectService;

@Service
/*@Component*/
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDao projectDao;
	
	public Project getProjectById(Integer projectId) {
		// TODO Auto-generated method stub
		return projectDao.getProjectById(projectId);
		
	}
	
	@Transactional
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		
		return projectDao.getProjects();
	}
	
	public Integer insertProject(Project project) {
		// TODO Auto-generated method stub
		return projectDao.insertProject(project);

	}
	
	
public Integer updateProjectStatus(Integer projectId, int projectStatusId) {
		// TODO Auto-generated method stub
		return projectDao.updateProjectStatus(projectId, projectStatusId);
	}
}
