package main.java.com.plm.dao;

import java.util.List;
import main.java.com.plm.model.Project;


public interface ProjectDao {
	Integer insertProject(Project project);
	Project getProjectById(Integer projectId);
	List<Project> getProjects();
	Integer updateProjectStatus(Integer projectId, int projectStatusId);
}
