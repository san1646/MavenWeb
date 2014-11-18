package main.java.com.plm.controller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import main.java.com.plm.form.KnightedWBSRateForm;
import main.java.com.plm.form.KnightedWBSTechnologyForm;
import main.java.com.plm.model.KnightedRateWrapper;
import main.java.com.plm.model.KnightedWBSRate;
import main.java.com.plm.model.KnightedWBSTechnology;
import main.java.com.plm.model.KnightedWbsComplete;
import main.java.com.plm.model.Project;
import main.java.com.plm.model.ProjectKWBS;
import main.java.com.plm.model.ProjectKWBSId;
import main.java.com.plm.model.User;
import main.java.com.plm.service.ContactService;
import main.java.com.plm.service.TechnologyService;
import main.java.com.plm.validators.ValidationResponse;
import oracle.sql.DATE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the create, add technology requests.
 */
/**
 * @author sanket.bharaswadkar
 *
 */
/**
 * @author sanket.bharaswadkar
 *
 */
@Controller
public class TechnologyController{
	static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomeController.class.getName());
	@Autowired
    private TechnologyService technologyService;
	
	@Autowired
	private Project project;

	@RequestMapping(value = "/technology", method = { RequestMethod.GET })
	public String technology(final HttpServletRequest request,
            final HttpServletResponse response, Model model, HttpSession session) {
		log.info("***TechnologyController: Adding Technology...");
		
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		String app_name = resources.getMessage("app_name", null, "PLM", null);
		
		 model.addAttribute("app_name", app_name);
		 model.addAttribute("version", version);
		 model.addAttribute("year", year);
		 
		 /*KnightedWBSTechnology object added to the model.
		  * It will be used when the form is submitted
		  * and flow returns to the method submitKnightedWBS() */
		 List<KnightedWBSTechnology> knightedWBSTechnologyList = new ArrayList<KnightedWBSTechnology>();
		 List<KnightedWBSTechnology> knightedWBSTechnologyListFinal = new ArrayList<KnightedWBSTechnology>();
		 
		 /*For MySQL - Adding 8 blank items to make the list start at [8]
		  * The JSP has been configured to use the list from 8 for the previous Oracle DB */
		 for(int i=0;i<8;i++){knightedWBSTechnologyListFinal.add(new KnightedWBSTechnology()); }
		 
		 //knightedWBSTechnologyList.add(new KnightedWBSTechnology(new Integer(60),"60.1","55"));//hardcoded as of now...
		 knightedWBSTechnologyList = technologyService.getKnightedWBS();
		 //Loop to add KnightedWBSTechnology objects. Number of objects depends on the form size.
		/* for (int i = 0; i < 100; i++) {
			 knightedWBSTechnologyList.add(new KnightedWBSTechnology());
		}*/
		 
		 //Add projectKWBS list into the knightedForm - 11/5/2013
		 List<ProjectKWBS> projectKWBSList = new ArrayList<ProjectKWBS>();
		 
		 //Get the session project
		    Object editProject = session.getAttribute("editProject");
			Project sessionProject = (Project) editProject;
			if(sessionProject==null){
				Object currentProject = session.getAttribute("currentProject");
				sessionProject = (Project) currentProject;
			}
			
		 projectKWBSList = technologyService.getProjectKWBS(sessionProject.getProjectId());
		
		 HashMap <Integer, ProjectKWBS> hashMapProjectKWBS = new HashMap<Integer, ProjectKWBS>();
		//Check if projectKWBSList is empty
		 if (!projectKWBSList.isEmpty()) {
			for (ProjectKWBS i : projectKWBSList) {
				hashMapProjectKWBS.put(i.getProjectKWBSId().getKnightedWbsId(),
						i);
			}
		}
		 
		 /* CommaIssue
		  * Only for taskNumber = 60.5 & taskNumber = 60.7.5, extra comma is being inserted.
		  * To eliminate that, reset the hashMapProjectKWBS value*/
		 String cleanNote = "";
		if (hashMapProjectKWBS.get(2736) != null) {
			// 2736 is for 60.5
			cleanNote = hashMapProjectKWBS.get(2736).getNoteDescription();
		}
		// String cleanHours = hashMapProjectKWBS.get(2750).getHours();//2750 is for 60.7.5
		 if(cleanNote!=null && !cleanNote.isEmpty()){
			 if(cleanNote.charAt(cleanNote.length()-1)==','){ cleanNote = cleanNote.substring(0, cleanNote.length()-1);}
			 hashMapProjectKWBS.get(2736).setNoteDescription(cleanNote);
		 }
		 String cleanHours = "";
		 if(hashMapProjectKWBS.get(2750)!=null){
			 cleanHours = hashMapProjectKWBS.get(2750).getHours();//2750 is for 60.7.5
		 }
		if (cleanHours!=null && !cleanHours.isEmpty()) {
			cleanHours = cleanHours.split(",")[0];
			// 2750 is for 60.7.5
			hashMapProjectKWBS.get(2750).setHours(cleanHours);
		}
		
		 /*DEBUG*/
		 //Muted
		 /*for (Object key : hashMapProjectKWBS.keySet()) {
				String k =  key.toString() ;
				String kNote = hashMapProjectKWBS.get(key).getNoteDescription();
			}*/
		 /*DEBUG*/
		 
		 /*This for loop is to link knightedWBSTechnologyList items to projectKWBSList items
		  * where taskNumber is equal */
		 for (Iterator iterator = knightedWBSTechnologyList.iterator(); iterator.hasNext();) {
			KnightedWBSTechnology knightedWBSTechnology = (KnightedWBSTechnology) iterator.next();
			if( hashMapProjectKWBS.containsKey(knightedWBSTechnology.getKnightedWbsId()) ){
				/*Here, each attribute of ProjectKWBS is set to the transient fields of knightedWBSTechnology 
				 * This makes them available in the View, as we are passing only knightedWBSTechnology wrapped in the Form object */
				knightedWBSTechnology.setNoteDescription((hashMapProjectKWBS.get(knightedWBSTechnology.getKnightedWbsId()).getNoteDescription()) );
				knightedWBSTechnology.setHours(hashMapProjectKWBS.get(knightedWBSTechnology.getKnightedWbsId()).getHours());
				knightedWBSTechnology.setUserId(hashMapProjectKWBS.get(knightedWBSTechnology.getKnightedWbsId()).getUserId());
				knightedWBSTechnology.setRate(hashMapProjectKWBS.get(knightedWBSTechnology.getKnightedWbsId()).getRate());
				
				knightedWBSTechnologyListFinal.add(knightedWBSTechnology);
			}
			else{
				knightedWBSTechnology.setNoteDescription(null);
				knightedWBSTechnology.setHours("0");
				
				knightedWBSTechnologyListFinal.add(knightedWBSTechnology);
			}
		 }
					/* 		To do list
					apply notes to all line items --done for 60 and 61
					apply validation to all input boxes
					fix the multiple login problem 
					fix the session null problem		*/
		 KnightedWBSTechnologyForm knightedForm = new KnightedWBSTechnologyForm();
		 knightedForm.setKnightedWBSTechnology(knightedWBSTechnologyListFinal);
		 /*knightedForm.setProjectKWBS(projectKWBSList);*/
		 //ProjectKWBS
		 model.addAttribute("knightedWBSTechnologyForm" , knightedForm);
		
		 /*model.addAttribute("totalHours60" , getTotalHours("60."));
		 model.addAttribute("totalHours61" , getTotalHours("61."));
		 model.addAttribute("totalHours62" , getTotalHours("62."));
		 model.addAttribute("totalHours63" , getTotalHours("63."));*/
		 
		 model.addAttribute("totalHours60" ,technologyService.getKnightedWbsServiceTotalHours("60.", sessionProject.getProjectId()));
		 model.addAttribute("totalHours61" , technologyService.getKnightedWbsServiceTotalHours("61.", sessionProject.getProjectId()));
		 model.addAttribute("totalHours62" , technologyService.getKnightedWbsServiceTotalHours("62.", sessionProject.getProjectId()));
		 model.addAttribute("totalHours63" , technologyService.getKnightedWbsServiceTotalHours("63.", sessionProject.getProjectId()));
		 
		 model.addAttribute("totalHours606" , technologyService.getKnightedWbsServiceTotalHours("60.6.", sessionProject.getProjectId()));
		 model.addAttribute("totalHours6062" , technologyService.getKnightedWbsServiceTotalHours("60.6.2.", sessionProject.getProjectId()));
		 model.addAttribute("totalHours60624" , technologyService.getKnightedWbsServiceTotalHours("60.6.2.4.", sessionProject.getProjectId()));
		 model.addAttribute("totalHours607" , technologyService.getKnightedWbsServiceTotalHours("60.7.", sessionProject.getProjectId()));
		 model.addAttribute("totalHours6077" , technologyService.getKnightedWbsServiceTotalHours(" 60.7.7.", sessionProject.getProjectId()));
		 
		 System.out.println(knightedForm.getKnightedWBSTechnologies());
		return "createTechnology";
	}
	
	@RequestMapping(value = "/techsave")
	public String save(final HttpServletRequest request,
            final HttpServletResponse response, Map<String, Object> model){
		log.info("***TechnologyController: Adding Technology...");
		
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		
		 model.put("version", version);
		 model.put("year", year);
		 
		return "save";
	}

	@RequestMapping(value = "/loadknighted", method = RequestMethod.GET)
	public String loadKnightedWBS(final HttpServletRequest request,
            					  final HttpServletResponse response, 
            					  Model model){
		log.info("***TechnologyController: knightedWBSSave...");
		 model.addAttribute("knightedWBSTechnology" , new KnightedWBSTechnology());
		 return "technology";
	}
	
	@RequestMapping(value = "/saveknighted", method = RequestMethod.POST)
	public String saveKnightedWBS(final HttpServletRequest request,
            					  final HttpServletResponse response, 
            					  Model model, @ModelAttribute KnightedWBSTechnology knightedWBSTechnology){
		log.info("***TechnologyController: knightedWBSSave...");
		
		 /*Save the Knighted WBS object*/
		 //KnightedWBSTechnology knightedWBSTechnology = new KnightedWBSTechnology();
		if(knightedWBSTechnology==null){
		 knightedWBSTechnology = new KnightedWBSTechnology();
		 knightedWBSTechnology.setTaskNumber("60.1");
		 knightedWBSTechnology.setHours("555");
		}
		 /*Call the Service method*/
		 technologyService.insertKnightedWBS(knightedWBSTechnology);
		 log.info("***Knighted WBS inserted!");
		 model.addAttribute("message", "Successfully saved WBS: ");
		 return "technology";
	}
	
	
	
	/**
	 * @author sanket.bharaswadkar
	 * {@code public String submitKnightedWBS(@ModelAttribute("knightedWBSTechnologyForm") KnightedWBSTechnologyForm knightedWBSTechnologyForm ,
									BindingResult result, Model model, HttpSession session)}
									
	 * @param knightedWBSTechnologyForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 * This method accepts the knightedWBSTechnologyForm object from the View. 
	 * After binding with the current project in the session (sessionProject), 
	 * the work break down structure is persisted to the Database.
	 */
	@RequestMapping(value = "/technology", method=RequestMethod.POST)
	public String submitKnightedWBS(@ModelAttribute("knightedWBSTechnologyForm") KnightedWBSTechnologyForm knightedWBSTechnologyForm ,
									BindingResult result, Model model, HttpSession session){
		
		if (result.hasErrors()) {
		      return "error/knightedWbsError";
		    }
		
		List<KnightedWBSTechnology> knightedWBSFormList = new ArrayList<KnightedWBSTechnology>();
		List<ProjectKWBS> projectKWBSList = new ArrayList<ProjectKWBS>();
		
		if(knightedWBSTechnologyForm!=null){
		knightedWBSFormList = knightedWBSTechnologyForm.getKnightedWBSTechnologies();
		//projectKWBSList = knightedWBSTechnologyForm.getProjectKWBSList(); 
		}
		
		Object editProject = session.getAttribute("editProject");
		Project sessionProject = (Project) editProject;
		if(sessionProject==null){
		Object currentProject = session.getAttribute("currentProject");
		sessionProject = (Project) currentProject;
		}
		
		log.info("***TechnologyController: (ajax) submitKnightedWBS...");
		
		//Set<KnightedWBSTechnology> knightedWBSSet = new HashSet<KnightedWBSTechnology>(technologyService.getKnightedWBS());
		List<KnightedWBSTechnology> knightedWBSTechnologyListDb = new ArrayList<KnightedWBSTechnology>();
		knightedWBSTechnologyListDb = technologyService.getKnightedWBS();
		
		HashMap <String, String> hashMapKnightedWBSDb = new HashMap<String, String>();
		HashMap <String, String> hashMapKnightedWBSForm = new HashMap<String, String>();		
		
		HashMap <String, String> hashMapProjectKWBSForm = new HashMap<String, String>();
		
		for (KnightedWBSTechnology i : knightedWBSFormList) {
			
			/*CommaIssue
			  * This is a sanitization measure to eliminate the extra comma added to the hours field for taskNumber 60.7.5*/
			if(i.getTaskNumber().equalsIgnoreCase("60.7.5")){
				String cleanHours = i.getHours();
				
				String[] splitHours = cleanHours.split(","); 
				cleanHours = splitHours[splitHours.length-1];
				i.setHours(cleanHours);
			}
			/*CommaIssue*/
			
			hashMapKnightedWBSForm.put(i.getTaskNumber(), i.getHours());
		
			/*CommaIssue
			  * This is a sanitization measure to eliminate the extra comma added to the noteDescription of taskNumber 60.5*/
			if(i.getTaskNumber().equalsIgnoreCase("60.5")){
				String cleanNote = i.getNoteDescription();
				if(cleanNote.length()!=0){
					cleanNote = cleanNote.substring(0, cleanNote.length()-1);
				}
				i.setNoteDescription(cleanNote);
			}
			
			
			
			 /*CommaIssue*/
			
			hashMapProjectKWBSForm.put(i.getTaskNumber(), i.getNoteDescription());
			
		}
		
		 
		 
		for (KnightedWBSTechnology i : knightedWBSTechnologyListDb) hashMapKnightedWBSDb.put(i.getTaskNumber(),i.getHours());
		
		/*final Map<String, String> comparisonResult =
		        compareEntries(hashMapKnightedWBSDb, hashMapKnightedWBSForm);
		    for(final Entry<String, String> entry : comparisonResult.entrySet()){
		        KnightedWBSTechnology k = new KnightedWBSTechnology();
		        k.setTaskNumber(entry.getKey().replace(",", ""));
		        k.setHours(entry.getValue());
		        
		        if(k.getHours().isEmpty()){
					k.setHours("0");
				}
		        if(k!=null){technologyService.insertKnightedWBS(k);}
		    }*/
		
		
		/*Get current values from db. Compare them with form values.
		 * Update only the modified values.*/
		List<ProjectKWBS> projectKWBSListDb = new ArrayList<ProjectKWBS>();
		projectKWBSListDb = technologyService.getProjectKWBS(sessionProject.getProjectId());
		 
		
		String loopTaskNumber, loopHours;
		Integer projectId = (Integer) sessionProject.getProjectId();
		for (Iterator iterator = knightedWBSFormList.iterator(); iterator
				.hasNext();) {
			KnightedWBSTechnology knightedWBSTechnology = (KnightedWBSTechnology) iterator
					.next();
			 loopTaskNumber = knightedWBSTechnology.getTaskNumber();
			 loopHours = hashMapKnightedWBSForm.get(loopTaskNumber);
			 
			 ProjectKWBS projectKWBS = new ProjectKWBS(
					 new ProjectKWBSId(null,projectId), // project Id
					 loopHours , //hours
					 null, //rate - As of now, rate is fetched in  the Database SF by using the taskNumber 
					 hashMapProjectKWBSForm.get(loopTaskNumber), // note
					 null, //time stamp - Current date is set in the DaoImpl method
					 session.getAttribute("username").toString() //username
					 );
					/* sessionProject.getProjectId()));*/
			 
			 
			 
			 
			technologyService.mergeProjectKWBS( projectKWBS, loopTaskNumber, loopHours);
		}
		
		/*test code */
		//technologyService.mergeProjectKWBS(new ProjectKWBS(new ProjectKWBSId(2732,1160), "15.15", "999", "note from constructor", null, "temp")	, "60.1", "15.15");
		/*test code */
		
		/*for (Iterator iterator = knightedWBSFormList.iterator(); iterator
				.hasNext();) {
			KnightedWBSTechnology knightedWBSTechnology = (KnightedWBSTechnology) iterator
					.next();
			//Iterate through the List; Save to the database if it is not null
			log.info("-->>knightedWBSTechnology.getHours()"+knightedWBSTechnology.getHours());
			if(knightedWBSTechnology!=null){
				//To remove the extra commas; a temporary fix
				//Future change: Delegate to the ValidationController Class
				knightedWBSTechnology.setHours(knightedWBSTechnology.getHours().replace(",", ""));
				//To truncate to 30 characters; a temporary fix
				if(knightedWBSTechnology.getTaskNumber().length() > 30){
					knightedWBSTechnology.setTaskNumber(knightedWBSTechnology.getTaskNumber().substring(0, 29));
				}
				//To avoid null entries in the database, replace with 0
				//This avoids the problem of task number concatenation
				//Task number is being concatenated and multiple entries are stored in the same row
				if(knightedWBSTechnology.getHours().isEmpty()){
					knightedWBSTechnology.setHours("0");
				}
				//Getting Project object from the session. Setting it to the KnightedWBS
				//Project project = (Project)session.getAttribute("currentProject");
				knightedWBSTechnology.setTaskName(sessionProject.getProjectId().toString());
				//First check if entry exists
				//Yes - update query
				//No - insert query
				//technologyService.insertKnightedWBS(knightedWBSTechnology);
				//technologyService.updateKnightedWBS(knightedWBSTechnology);
			}
		}*/
		//testing Project_KWBS
		
		/*for (Iterator iterator = projectKWBSList.iterator(); iterator
				.hasNext();) {
			ProjectKWBS projectKWBS = (ProjectKWBS) iterator
					.next();
			ProjectKWBSId id =  new ProjectKWBSId();
			//id.setKnightedWbsId(2737);//default
			id.setProjectId(sessionProject.getProjectId());//sessionProject
			projectKWBS.setProjectKWBSId(id);
			
			//projectKWBS.setRate("115");
			//projectKWBS.setTimeStamp("06-NOV-13");
			projectKWBS.setUserId(session.getAttribute("username").toString());
			projectKWBS.setHours(knighted WBSFormList.get(0).getHours());
			hashMapKnightedWBSDb.containsKey(flightOTI);
			Here the projectKWBS is detached  from
			 * the knightedForm and saved to the database (PROJECT_KWBS)
			
			projectKWBS.setNoteDescription(projectKWBS.getNoteDescription());
			
			technologyService.mergeProjectKWBS(projectKWBS, knightedWBSFormList.get(0).getTaskNumber(), knightedWBSFormList.get(0).getHours() );
		}*/
		
		//testing Project_KWBS

		model.addAttribute("taskNumber", knightedWBSFormList.get(0).getTaskNumber());
		
		String message = "Knighted WBS has been saved!";
		model.addAttribute("message", message); 
		return "redirect:/createProject";		
	}

	/**
	 * Works with any two maps with common key / value types.
	 * The key type must implement Comparable though (for sorting).
	 * Returns a map containing all keys that appear in either of the supplied maps.
	 * The values will be true if and only if either
	 *   - map1.get(key)==map2.get(key) (values may be null) or
	 *   - map1.get(key).equals(map2.get(key)).
	 */
	public static <K extends Comparable<? super K>, V>
	Map<K, V> compareEntries(final Map<K, V> map1, final Map<K, V> map2){
		
		if(map1.isEmpty()){
			return map2;
		}
		if(map2.isEmpty()){
			return map1;
		}
		
	    final Collection<K> allKeys = new HashSet<K>();
	    allKeys.addAll(map1.keySet());
	    allKeys.addAll(map2.keySet());
	    final Map<K, V> result = new TreeMap<K, V>();
	    for(final K key : allKeys){
	    	//map1 has form and map2 has database WBS
	    	//If map1 value is ne to map2 value, then insert value into result
	    	//This is to make sure, we insert only modified values into the database
	    	if(!(map1.get(key).equals(map2.get(key)) )){
	    		result.put(key,map2.get(key) );
	    	}
	    }
	    return result;
	}

	
	@RequestMapping(value="/knightedWBSTechnologyFormAjax.json",method=RequestMethod.GET)
	public String showForm(){
		return "createTechnology";
	}
	
	@RequestMapping(value = "/knightedWBSTechnologyFormAjax.json", method = RequestMethod.POST)
	public @ResponseBody ValidationResponse processForm(@ModelAttribute(value = "user") User user, 
			BindingResult result) {
		
		List<User> userList = new ArrayList<User>();
		
		ValidationResponse res = new ValidationResponse();
		ValidationUtils.rejectIfEmpty(result, "name", "Hours can not be empty.");
		//ValidationUtils.rejectIfEmpty(result, "education", "hhh Education not be empty");
		if(!result.hasErrors()){
			userList.add(user);
			res.setStatus("SUCCESS");
			res.setResult(userList);
		}else{
			res.setStatus("FAIL");
			res.setResult(result.getAllErrors());
		}

		return res;
	}
	
	
	/* This method is used to get the total hours for a WBS.
	 * 
	 * 
	 * */
	public String getTotalHours(String serviceLevel) {
		float totalHours = 0;
		List<KnightedWBSTechnology> knightedWBSList = technologyService.getKnightedWBS();
		for (Iterator iterator = knightedWBSList.iterator(); iterator.hasNext();) {
			KnightedWBSTechnology knightedWBSTechnology = (KnightedWBSTechnology) iterator
					.next();
			if(knightedWBSTechnology.getHours()!=null && 
					knightedWBSTechnology.getTaskNumber().contains(serviceLevel))
			{totalHours += Float.parseFloat(knightedWBSTechnology.getHours());}
		}
		DecimalFormat df = new DecimalFormat("###.##");
		return df.format(totalHours);
	}
	
	@RequestMapping(value = "/totalHours", method=RequestMethod.GET)
	public ModelAndView  getTotalHoursAjax() {
		float totalHours = 0;
		List<KnightedWBSTechnology> knightedWBSList = technologyService.getKnightedWBS();
		for (Iterator iterator = knightedWBSList.iterator(); iterator.hasNext();) {
			KnightedWBSTechnology knightedWBSTechnology = (KnightedWBSTechnology) iterator
					.next();
			if(knightedWBSTechnology.getHours()!=null)
			{totalHours += Float.parseFloat(knightedWBSTechnology.getHours());}
		}
		return new ModelAndView("createTechnology", "ajaxmessage", "Total hours via ajax:"+Float.toString(totalHours)); 
	}
	
	///knightedrate
	@RequestMapping(value = "/knightedrate", method=RequestMethod.GET)
	public String getKnightedRate(Model model, HttpSession session){
		log.info("***TechnologyController: knightedRate...");
		String username = session.getAttribute("username").toString();
		model.addAttribute("username", username);
		
		//KnightedWBSRateForm knightedWBSRateForm = new KnightedWBSRateForm();
		//Set the current database rate values to the Form
		//knightedWBSRateForm.setKnightedWBSRates(technologyService.getKnightedRate());
		
		//model.addAttribute("knightedWBSRateForm" , knightedWBSRateForm);
		//model.addAttribute("message","Knighted Rates");
		
		/* Get the complete Knighted Wbs */
		List<KnightedWBSRate> knightedCompleteList = technologyService.getKnightedRate();
		KnightedRateWrapper knightedRateWrapper = new KnightedRateWrapper(knightedCompleteList);
		model.addAttribute("knightedRateWrapper" , knightedRateWrapper);
		
		
		return "knightedRateForm"; 
	}
	
	
	@RequestMapping(value = "/knightedrate", method=RequestMethod.POST)
	public String setKnightedRate(@ModelAttribute("knightedRateWrapper") KnightedRateWrapper knightedRateWrapper){
		log.info("***TechnologyController: knightedWBSSave...");
		//Slickgrid is awesome. We can even use SG for the WBS form.  
		//It has the tree structure grid which is ideal for the WBS. 
		//Sencha JS
		
		//from the database
		List<KnightedWBSRate> knightedCompleteListDb = technologyService.getKnightedRate();
				
		List<KnightedWBSRate> knightedWbsRateList = new ArrayList<KnightedWBSRate>();
		/*if(knightedRateWrapper.getKnightedWbsRate()!=null){
		knightedWbsRateList = knightedRateWrapper.getKnightedWbsRate();
		}*/
		/*else{
			KnightedWBSRate k = new KnightedWBSRate();
			k.setTaskNumber("60.1");
			k.setDescription("whatever");
			k.setRate("");
			k.setTaskName("");
			
			knightedWbsRateList.add(k);
			}*/
		
		
		//compare knightedCompleteListDb and knightedCompleteList;
		//Get the dirty objects into knightedCompleteListDirty
		List<KnightedWBSRate> knightedCompleteListDirty = new ArrayList<KnightedWBSRate>(); 
		
		
		/*for (Iterator iterator1 = knightedCompleteListDb.iterator(),  iterator2= knightedWbsRateList.iterator() ;
				iterator1.hasNext()  &&  iterator1.hasNext();) {
			KnightedWBSRate knightedWBSRateDb = (KnightedWBSRate) iterator1.next();
			KnightedWBSRate knightedWBSRateForm = (KnightedWBSRate) iterator2.next();
			
			if(knightedWBSRateDb.getTaskNumber().equals(knightedWBSRateForm.getTaskNumber())) {
				if(!knightedWBSRateDb.equals(knightedWBSRateForm)){
					//update to db
					knightedCompleteListDirty.add(knightedWBSRateForm);
				}
			}//end if for taskNumber
		}*/
		//update the dirty list
		
		
		
				
		/*HashMap <String, String> hashMapKnightedWBSRateDb = new HashMap<String, String>();
		HashMap <String, String> hashMapKnightedWBSRateForm = new HashMap<String, String>();		
		
		for (KnightedWBSRate i : knightedWBSRateFormList) hashMapKnightedWBSRateForm.put(i.getTaskNumber().toString(),i.getRate());
		for (KnightedWBSRate i : knightedWBSRateListDb) hashMapKnightedWBSRateDb.put(i.getTaskNumber().toString(),i.getRate());*/
		
		/*for (Iterator iterator = knightedWBSRateFormList.iterator(); iterator
				.hasNext();) {
			KnightedWBSRate knightedWBSRate = (KnightedWBSRate) iterator
					.next();
			//Iterate through the List; Save to the database if it is not null
			log.info("-->>knightedWBSTechnology.getHours()"+knightedWBSRate.getRate());
			if(knightedWBSRate!=null){
				if(knightedWBSRate.getRate().isEmpty()){
					knightedWBSRate.setRate("0");
				}
				//technologyService.insertKnightedWBS(knightedWBSTechnology);
				technologyService.insertKnightedRate(knightedWBSRate);
			}
			
		}	*/
		
		//model.addAttribute("message","Knighted Rates");
		return "redirect:/home";	
	}
	
	
}
