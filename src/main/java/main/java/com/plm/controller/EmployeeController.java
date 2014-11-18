package main.java.com.plm.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.plm.model.Employee;
import main.java.com.plm.model.Proj_Emp;
import main.java.com.plm.model.Proj_EmpId;
import main.java.com.plm.model.Project;
import main.java.com.plm.model.ProjectStatus;
import main.java.com.plm.service.EmployeeService;
import main.java.com.plm.service.Proj_EmpService;
import main.java.com.plm.validators.ValidationResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Proj_EmpService proj_EmpService;
	
	static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomeController.class.getName());

	@RequestMapping(value = "/employee", method = { RequestMethod.GET })
	public String technology(final HttpServletRequest request,
            final HttpServletResponse response, Map<String, Object> model) {
		log.info("***Adding an employee...");
		
		MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1", null);
		String year = resources.getMessage("curr_year", null, "2013", null);
String app_name = resources.getMessage("app_name", null, "PLM", null);
			//To avoid memory leak, close the resource
			//resources.close(); //method not available
	
		model.put("app_name", app_name);
		 model.put("version", version);
		 model.put("year", year);
		 
		 
		return "addEmployee";
	}
	
	@RequestMapping(value = "/addEmployee{employeeIds}", method = { RequestMethod.GET })
	public @ResponseBody ValidationResponse  addEmployee(@RequestParam(value="employeeIds", required = false)  String employeeIds, 
			HttpSession session, 
            Map<String, Object> model ) {
		log.info("***Adding an employee...");
		//Split the employeeIds by ',' to get a list of employee id's
		String [] employeeIdArray = {};
		if(employeeIds!=null && !employeeIds.isEmpty()){
			employeeIdArray = employeeIds.split(",");
		}
		
		ValidationResponse res = new ValidationResponse();
		Project sessionProject = null;
		try{
			sessionProject = (Project) session.getAttribute("editProject");
		
			if(sessionProject==null){
				sessionProject = (Project) session.getAttribute("currentProject");
				}
		}catch (java.lang.ClassCastException cce) {
			// TODO: handle exception
			log.error("java.lang.String cannot be cast to main.java.com.plm.model.Project here at the addEmployee site");
		}
		int updateStatus = 0;
		/* To get the current ProjectId */
		try{
			Proj_Emp proj_Emp = new Proj_Emp();
			Proj_EmpId proj_EmpId = new Proj_EmpId();
			
			java.util.Date today = new java.util.Date();
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			
			for (int i = 0; i < employeeIdArray.length; i++) {
				if (employeeIdArray[i] != null && !employeeIdArray[i].isEmpty()
						&& sessionProject.getProjectId() != null) {
					proj_EmpId.setEmployee_employeeId(Integer
							.parseInt(employeeIdArray[i]));
					proj_EmpId.setProject_projectId(sessionProject.getProjectId());

					proj_Emp.setProj_EmpId(proj_EmpId);
					proj_Emp.setStartDate(dateFormatter.format(today));
					updateStatus = proj_EmpService.associateProj_Emp(proj_Emp);
				}

			}
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
	
	
	/**
	 * @param employees
	 * @param session
	 * @param model
	 * @param result
	 * @return json response consisting of list of employees from the db
	 */
	@RequestMapping(value = "/getEmployees{term}", method = { RequestMethod.GET })
	public @ResponseBody Map<Integer, String>  getEmployees(@RequestParam(value="term", required = false) String term) {
		List<Employee> employees = employeeService.getEmployees();
		Map<Integer, String> mapJsonEmployees = new LinkedHashMap<Integer, String>();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			//if(employee.getFirstName()==null || employee.getLastName()==null || term==null){continue;}
			if(employee.getLastName()==null){employee.setLastName("");}//If employee lastname is null, NPE is thrown. To avoid that, set it to empty string.
			if(employee.getFirstName()==null){employee.setFirstName("");}			
				if(employee.getLastName().toLowerCase().contains(term.toLowerCase()) || employee.getFirstName().toLowerCase().contains(term.toLowerCase())){
					mapJsonEmployees.put(employee.getEmployeeId(), employee.getEmployeeId().toString()+" - "+employee.getFirstName()+" "+employee.getLastName());
				}
		}
		return mapJsonEmployees;
	}

}
