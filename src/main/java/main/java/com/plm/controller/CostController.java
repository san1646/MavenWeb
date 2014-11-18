package main.java.com.plm.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import main.java.com.plm.model.KnightedWBSRate;
import main.java.com.plm.model.KnightedWBSTechnology;
import main.java.com.plm.model.Project;
import main.java.com.plm.model.ProjectKWBS;
import main.java.com.plm.service.TechnologyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CostController {

	static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomeController.class.getName());
	@Autowired
    private TechnologyService technologyService;
	
	@RequestMapping(value = "/calculateCost", method = { RequestMethod.GET })
	public String calculateKnightedCost(Model model, HttpSession session){
		//Get the rate for Knighted
		List<KnightedWBSRate> knightedWBSRate = technologyService.getKnightedRate();
		//Get the hours for the current project
		List<KnightedWBSTechnology> knightedWBSTechnology = technologyService.getKnightedWBS();
		
		//Get the PROJECT_KWBS for the current project
		Object editProject = session.getAttribute("editProject");
		Project sessionProject = (Project) editProject;
		if(sessionProject==null){
		Object currentProject = session.getAttribute("currentProject");
		sessionProject = (Project) currentProject;
		}
		
		List<ProjectKWBS> projectKWBSList = technologyService.getProjectKWBS(sessionProject.getProjectId());
		Float total = new Float(0);
		Float cost = new Float(0);
		
		Map<String, Float> mapCost = new TreeMap<String, Float>();
		if(!projectKWBSList.isEmpty()){
			for (Iterator iterator = projectKWBSList.iterator(); iterator
					.hasNext();) {
				ProjectKWBS projectKWBS = (ProjectKWBS) iterator.next();
				
				cost = Float.parseFloat(projectKWBS.getHours())  * 	Float.parseFloat(projectKWBS.getRate());
				total += cost;
				//Add only when cost is non-zero
				if( cost.compareTo(new Float(0)) != 0 ){mapCost.put(projectKWBS.getProjectKWBSId().getKnightedWbsId().toString(), cost );}
				
			}
		}
		
			DecimalFormat df = new DecimalFormat("###.##");
			
			model.addAttribute("total",df.format(total));
			model.addAttribute("mapCost",mapCost);
			
		return "cost";
	}
}
