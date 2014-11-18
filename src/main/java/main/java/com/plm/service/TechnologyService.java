package main.java.com.plm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.java.com.plm.model.KnightedWBSRate;
import main.java.com.plm.model.KnightedWBSTechnology;
import main.java.com.plm.model.KnightedWbsComplete;
import main.java.com.plm.model.ProjectKWBS;
import main.java.com.plm.model.ProjectKWBSId;

@Service
public interface TechnologyService {
	void insertKnightedWBS(KnightedWBSTechnology knightedWBSTechnology);
	List<KnightedWBSTechnology> getKnightedWBS();
	int updateKnightedWBS(KnightedWBSTechnology knightedWBSTechnology);
	
	//Knighted Rate Structure methods
	List<KnightedWBSRate> getKnightedRate();
	int insertKnightedRate(KnightedWBSRate knightedWBSRate);
	
	//Project_KWBS insert
	ProjectKWBSId insertProjectKWBS(ProjectKWBS projectKWBS);
	
	//Project_KWBS getList
	List<ProjectKWBS> getProjectKWBS();
	//Project_KWBS getList by projectId
	List<ProjectKWBS> getProjectKWBS(Integer projectId);
		
	//stored proc - mergeProjectKWBS
	public void mergeProjectKWBS(ProjectKWBS kwbs, String taskNumber, String hours);
	
	//method to get total hours from PROJECT_KWBS
		public Float  getKnightedWbsServiceTotalHours(String serviceLevel, Integer projectId);
		
		//get complete knighted wbs
		public List<KnightedWbsComplete> getKnightedWbsComplete();
}
