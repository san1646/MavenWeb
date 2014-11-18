package main.java.com.plm.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.plm.form.Contact;
import main.java.com.plm.model.Customer;
import main.java.com.plm.model.KnightedWBSTechnology;
import main.java.com.plm.model.Project;
import main.java.com.plm.service.ContactService;
import main.java.com.plm.service.CustomerService;
import main.java.com.plm.service.ProjectService;
import main.java.com.plm.service.impl.ProjectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	 static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomeController.class.getName());
	 
	@Autowired
	Comparator<String> comparator;
	
	@Autowired
	    private ContactService contactService;
	
	@Autowired
    private ProjectService projectService;
	
	@Autowired
    private CustomerService customerService;


	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String login(final HttpServletRequest request,
            final HttpServletResponse response, Map<String, Object> model) {
		
		 log.info("***Request object received for method "
                + request.getMethod());
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		String app_name = resources.getMessage("app_name", null, "PLM", null);
		
		 model.put("version", version);
		 model.put("year", year);
		 model.put("app_name", app_name);
		  //System.out.println("HomeController: Passing through...");
		  log.info("***HomeController: Login...");
		  log.info("***response content type is not set : "
	                + response.getContentType());
		  
		return "login";
	}
	
	@RequestMapping(value = "/home", method = { RequestMethod.GET })
	public String home(final HttpServletRequest request,

            final HttpServletResponse response, 
            Map<String, Object> model,
            HttpSession session) {
		
		log.info("***Request object received for method "
                + request.getMethod());
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		String app_name = resources.getMessage("app_name", null, "PLM", null);
		
		
		//Check if session is present
				if(session!=null){
					String username = session.getAttribute("username").toString();
					model.put("username", username);
				}
		//To list all the projects
		List<Project> projects = new ArrayList<Project>();
		projects = projectService.getProjects();
		
		//Get all the customers
		List<Customer> customers = new ArrayList<Customer>();
		customers = customerService.getCustomer();
		
		TreeMap<Integer, Customer> customerMap = new TreeMap<Integer, Customer>();
		for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
			Customer customer = (Customer) iterator.next();
			customerMap.put(customer.getCustomerId(), customer);
		}
		
		Map<Project, Customer> homeDashboardMap = new LinkedHashMap<Project, Customer>();
		for (Iterator iterator = projects.iterator(); iterator.hasNext();) {
			Project project = (Project) iterator.next();
			
			if(project.getCustomerId()!=null && !project.getCustomerId().isEmpty()){
				homeDashboardMap.put(project, customerMap.get( Integer.parseInt(project.getCustomerId())));
			}
		}
		
		model.put("homeDashboardMap", homeDashboardMap);
		
		model.put("projects", projects);
		//Remove the editProject object from the session
		session.removeAttribute("editProject");
		
		 model.put("version", version);
		 model.put("year", year);
		 model.put("app_name", app_name);
		  //System.out.println("HomeController: Passing through...");
		  log.info("***HomeController: Home...");
		  log.info("***response content type is not set : "
	                + response.getContentType());
		return "home";
		
	}

	/*@RequestMapping(value = "/version")
    public ModelAndView handleRequest(final HttpServletRequest request,
            final HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = null;


        MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "Default", null);
		
        //the view, attribute name and value
        modelAndView = new ModelAndView("home", "version", version);
        modelAndView.addObject(version);//just the attribute - name auto-generated
        
        modelAndView.addObject("version", version);//atribute and name
        System.out.println("Version ->>"+version);
        return modelAndView;
    }*/
	
	
	/*@RequestMapping(value = "/")
	public String home() {
		
		  System.out.println("HomeController: Passing through...");
		  
		  //String version;
		  ModelAndView modelAV = new ModelAndView();
		  MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
			String version = resources.getMessage("curr_version", null, "Default", null);
			modelAV.addObject("version",version.toString());//  addAttribute("version", message);
			
			
		return "home";
	}*/
	
	/*ModelAndView method, handleRequest is trying to send message from version.properties.
	 * The view is set to 'home' and object name is 'version23'.
	 * It is not correctly passing the value to View.*/
	/*@RequestMapping(value = "/version", method = RequestMethod.GET)
	public String getVersion(@RequestParam("version") String version, Model model)  throws Exception{
		
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String message = resources.getMessage("curr_version", null, "Default", null);
		model.addAttribute("version", message);
        return "home";
    }*/
	
	@RequestMapping(value = "/compare", method = RequestMethod.GET)
	public String compare(@RequestParam("input1") String input1,
			@RequestParam("input2") String input2, Model model) {

		int result = comparator.compare(input1, input2);
		String inEnglish = (result < 0) ? "less than" : (result > 0 ? "greater than" : "equal to");

		String output = "According to our Comparator, '" + input1 + "' is " + inEnglish + "'" + input2 + "'";

		model.addAttribute("output", output);
		return "compareResults";
	}

	@RequestMapping(value="/savedata", method = { RequestMethod.GET })
	public String saveToDb(final HttpServletRequest request,
            final HttpServletResponse response, Map<String, Object> model) { //@RequestParam("contact") Contact contact
		try{
			Contact contact = new Contact("Toto", "Chan", "totochan@toto.chan", "3669");
		contactService.insert(contact);
		System.out.println("Contact inserted!");
		log.info("***Project inserted!");
		
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		String app_name = resources.getMessage("app_name", null, "PLM", null);
		
		 model.put("version", version);
		 model.put("year", year);
		 model.put("app_name", app_name);
		 
		}catch(Exception e){	
			log.info("***Exception ---!!!"+e.getLocalizedMessage());
			log.info("***Exception ---~~~"+e.getMessage());
			log.info("***Exception ---###"+e.getStackTrace());
		}
		
		return "home";
	}
	
	
}
