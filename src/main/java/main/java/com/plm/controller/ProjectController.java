package main.java.com.plm.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.plm.model.Customer;
import main.java.com.plm.model.CustomerType;
import main.java.com.plm.model.Employee;
import main.java.com.plm.model.Proj_Emp;
import main.java.com.plm.model.Project;
import main.java.com.plm.model.ProjectStatus;
import main.java.com.plm.model.User;
import main.java.com.plm.service.CustomerService;
import main.java.com.plm.service.CustomerTypeService;
import main.java.com.plm.service.EmployeeService;
import main.java.com.plm.service.Proj_EmpService;
import main.java.com.plm.service.ProjectService;
import main.java.com.plm.validators.ValidationResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the create project requests.
 */
@Controller
@Scope("request")
public class ProjectController {
	static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomeController.class.getName());
	@Autowired
    private ProjectService projectService;
	
	/*@Autowired
	private Project project;*/
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CustomerService customerService;
	@Autowired
    private CustomerTypeService customerTypeService;
	
	@Autowired
	private Proj_EmpService proj_EmpService;

	@RequestMapping(value = "/createProject{editProjectId}", method = { RequestMethod.GET })
	public String home(final HttpServletRequest request,
            final HttpServletResponse response, Map<String, Object> model, HttpSession session, 
            @RequestParam(value="editProjectId", required = false) String editProjectId) {
		log.info("***ProjectController: Creating new project...");
		
		/*Session time out leads to session object being null;
		If user clicks on a project link, 
		control redirects to the login page and throws a null pointer exception*/
		//if(session==null){return "home";}
		
		try{
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		String app_name = resources.getMessage("app_name", null, "PLM", null);
		String username = session.getAttribute("username").toString();
		model.put("username", username);
		
		//This is when Edit link on the Home screen is clicked,
	 	//It passes the ProjectId in the session attr editProjectId
	 	session.setAttribute("editProjectId", editProjectId);
	 	
		model.put("app_name", app_name);
		model.put("version", version);
		model.put("year", year);
		
		return "createProject";
		
		}catch(Exception e){
			log.error(e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/createProject", method = { RequestMethod.POST })
	public String createProjectPost(final HttpServletRequest request,

            final HttpServletResponse response, Map<String, Object> model, HttpSession session, 
            @RequestParam(value="editProjectId", required = false) String editProjectId) {
		log.info("***ProjectController: Creating new project...");
		
		log.info("***ProjectController: createProjectPost..."+model.toString());
		/*Session time out leads to session object being null;
		If user clicks on a project link, 
		control redirects to the login page and throws a null pointer exception*/
		//if(session==null){return "home";}
		
		try{
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		String app_name = resources.getMessage("app_name", null, "PLM", null);
		String username = session.getAttribute("username").toString();
		model.put("username", username);
		
		//This is when Edit link on the Home screen is clicked,
	 	//It passes the ProjectId in the session attr editProjectId
	 	session.setAttribute("editProjectId", editProjectId);
	 	
		model.put("app_name", app_name);
		 model.put("version", version);
		 model.put("year", year);
		 
		return "redirect:/technology";
		
		}catch(Exception e){
			log.error(e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/project", method = { RequestMethod.GET })
	public String projectHome(final HttpServletRequest request,


            final HttpServletResponse response, Model model, HttpSession session) {
		log.info("***ProjectController: Creating new project...");
		
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		String app_name = resources.getMessage("app_name", null, "PLM", null);
		
		 model.addAttribute("app_name", app_name);
		 model.addAttribute("version", version);
		 model.addAttribute("year", year);
		 
		 List<Project> projectList = projectService.getProjects();
		 
		 //Project project = new Project(); 
		 
		 
		//This is for the @RequestParam attr
			//If not null, Set it to model
			//if null, ignore
		 Project editProjectById = null;
		 Object editProjectId = session.getAttribute("editProjectId");
			if(editProjectId!=null){
		 		model.addAttribute("editProjectId",	editProjectId.toString());
		 		model.addAttribute("projectPageTitle","Edit project");
		 		//Once we get the Project number, we set it to the session attribute, 'editProject'
		 		//This has the advantage of re-using the rest of the flow down here.
		 		//Now, the rest flow is exactly same as 'edit' button in the 'Find Project' functionality

 				editProjectById =  projectService.getProjectById(Integer.parseInt( editProjectId.toString() ));
		 		session.setAttribute("editProject", editProjectById);
		 		
		 		//To get the customer name
		 		List<Customer> customers = customerService.getCustomer(Integer.parseInt(editProjectById.getCustomerId() ) );
		 		model.addAttribute("customerName",  customers.get(0).getCustomerName());
		 	}
			
		 /*This is to persist the Project object to the database
			 * When user clicks home screen, object is saved. 
			 * Until then, it is persisted in the Session
			 * 
			 * Edit project - Find project redirects here. editProject is the Project passed for editing
			 * If it is present, edit it.
			 * else, get the current project from the session*/
		 
		 		
			Project sessionProject = null;
			try{
			sessionProject = (Project) editProjectById;
			//model.addAttribute("", attributeValue)
			}catch (java.lang.ClassCastException cce) {
				// TODO: handle exception
				log.error("java.lang.String cannot be cast to main.java.com.plm.model.Project here at the sessionProject casting site");
			}
			if(sessionProject==null){
				/*Object currentProject = session.getAttribute("currentProject");
				sessionProject = (Project) currentProject;*/
				  sessionProject = new Project();
					  sessionProject.setDepartmentId("100");// 100 - Test Department set as default, 
					  sessionProject.setCustomerId("292"); // Default set to 292 - Walmart
					  sessionProject.setStatusId(1); //Default to Status 1
				      Integer projectId = projectService.insertProject(sessionProject);
				      sessionProject.setProjectId(projectId);
				      session.setAttribute("currentProject", sessionProject);
				      model.addAttribute("projectId", projectId);
				      model.addAttribute("projectPageTitle","New project");
				  }
			//Integer projectId = projectService.insertProject(project);
			 
		 // Set the defaultProject JSP variable to the sessionProject; This is the latest and correct project
		  model.addAttribute("defaultProject", sessionProject); 
		  
		  /*Project Status - get the status from the db
		  * Set into the ProjectStatus object and pass to the model*/
			 
		ProjectStatus projectStatus = new ProjectStatus();
		projectStatus.setProjectId(sessionProject.getProjectId());
		 
		if(sessionProject.getStatusId()!=null){
			 projectStatus.setProjectStatusId(sessionProject.getStatusId());
		}
		else{
			 //Assign StatusId=1 (Unassigned)
			 projectStatus.setProjectStatusId(1);}
		 
		model.addAttribute("projectStatus", projectStatus);
		 /*Project Status*/
		 
		 /*DropDown*/
		 /* CustomerType*/
		 
		 List<CustomerType> customerTypes = customerTypeService.getCustomerType();
		 Map< Integer, String > customerTypesMap = new LinkedHashMap<Integer, String>();

		 for (CustomerType i : customerTypes) customerTypesMap.put(i.getCustomerTypeId(),i.getCustomerTypeDescription());
		 
		 
		 if(!customerTypes.isEmpty()){
			 log.info("***Adding customerTypes in to the Model.");
				model.addAttribute("customerTypesMap", customerTypesMap);
		 }else{
			 log.info("***Adding default customerTypes in to the Model.");
			 customerTypesMap.put(0,"Default");
			 model.addAttribute("customerTypesMap", customerTypesMap);
		 }
		 /*CustomerType*/
		 
		 /* Employee List */
		 List<Employee> employees = employeeService.getEmployees();
		 model.addAttribute("employees",employees);
		 /* Employee List */
		 
		 /*Project Employees*/
		 List<Proj_Emp> proj_EmpList = proj_EmpService.getEmployeesForProject(Integer.parseInt(editProjectId.toString() ));
			List<Integer> employeeIdList = new ArrayList<Integer>();
			
			for (Iterator iterator = proj_EmpList.iterator(); iterator.hasNext();) {
				Proj_Emp proj_Emp = (Proj_Emp) iterator.next();
				if(proj_Emp.getProj_EmpId().getEmployee_employeeId()!=null)
					employeeIdList.add(proj_Emp.getProj_EmpId().getEmployee_employeeId());
			}
			if(!employeeIdList.isEmpty()){
				List<Employee> employeeList = employeeService.getEmployees(employeeIdList);
				model.addAttribute("employeeList", employeeList);
			}
			
			
			/*Project Employees*/
		 
		return "project";
	}
	@RequestMapping(value = "/save")
	public String save(final HttpServletRequest request,
            final HttpServletResponse response, Map<String, Object> model){
		log.info("***ProjectController: Saving new project...");
		
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		
		 model.put("version", version);
		 model.put("year", year);
		 
		return "save";
	}
	
	//findproject
	@RequestMapping(value = "/findprojectresult", method = { RequestMethod.POST })
	public String findProject(@ModelAttribute("project") Project project, final HttpServletRequest request,
            final HttpServletResponse response, Model model, HttpSession session){
		log.info("***ProjectController: Saving new project...");
		
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		
		 model.addAttribute("version", version);
		 model.addAttribute("year", year);
		 
		 //Find a Project
		 //Project project = projectService.getProjectById();
		 session.setAttribute("editProject", project);
		return "redirect:/createProject";
	}
	
	//findproject
	@RequestMapping(value = "/findproject", method = { RequestMethod.POST })
	public String findProjectPOST(@ModelAttribute("project") Project project, BindingResult result, Model model){
			log.info("***ProjectController: Saving new project...");
			
			MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
			String jquerystyle = resources.getMessage("jquerystyle", null, "yoyo", null);
			model.addAttribute("jquerystyle", jquerystyle);
			            
			Project projectResult = projectService.getProjectById(project.getProjectId());
			 //model.addAttribute("project", project);
			if(projectResult!=null){
				model.addAttribute("projectResult",projectResult);
				model.addAttribute("message", "Successfully found project");
			}
			else{
				model.addAttribute("projectResult",new Project());
				model.addAttribute("message", "Project not found.");
				}
			
			
			 
			return "findProjectResult";
		}
		
	//findproject
	@RequestMapping(value = "/findproject", method = { RequestMethod.GET })
	public String findProjectGET(Model model, HttpSession session){
					log.info("***ProjectController: Saving new project...");
					
					MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
					String jquerystyle = resources.getMessage("jquerystyle", null, "yoyo", null);
					model.addAttribute("jquerystyle", jquerystyle);
					            
					String username = session.getAttribute("username").toString();
					model.addAttribute("username", username);
					
					//Project projectResult = projectService.getProjectById(project.getProjectId());
					 //model.addAttribute("project", project);
					/*if(projectResult!=null){
						model.addAttribute("projectResult",projectResult);
						model.addAttribute("message", "Successfully found project");
					}*/
					/*else{
						model.addAttribute("projectResult",new Project());
						model.addAttribute("message", "Project not found.");
						}
					*/
					model.addAttribute("project",new Project());
					 
					return "findProject";
				}

	//ajaxPostProjectStatusUpdateForm
	@RequestMapping(value="/updateStatus",method=RequestMethod.POST)
	public @ResponseBody ValidationResponse addUser(@ModelAttribute(value="projectStatus") ProjectStatus projectStatus, 
						BindingResult result , HttpSession session){
					ValidationResponse res = new ValidationResponse();
				
					/* To get the current ProjectId*/
					Project sessionProject = null;

					try{
						sessionProject = (Project) session.getAttribute("editProject");
					
						if(sessionProject==null){
							sessionProject = (Project) session.getAttribute("currentProject");
							}
					}catch (java.lang.ClassCastException cce) {
						// TODO: handle exception
						log.error("java.lang.String cannot be cast to main.java.com.plm.model.Project here at the sessionProject casting site");
					}
					int updateStatus = 0;
					/* To get the current ProjectId */
					try{
						updateStatus = projectService.updateProjectStatus(sessionProject.getProjectId(), projectStatus.getProjectStatusId());
					}
					/* NPE occurs when ajax request is sent through IE9. Other browsers, this would not occur
					 * IE9 uses XDomainRequest, instead of XMLHttpRequest/ This causes the ajax post to remain null at the server side*/
					catch(NullPointerException npe){ updateStatus = 0; log.error(npe.getMessage());}
					catch(Exception e){log.error(e.getMessage());}
					
					if(updateStatus==1)
						res.setStatus("SUCCESS");
					else 
						res.setStatus("FAIL");

					return res;
				}

}