package main.java.com.plm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentController {

	static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(HomeController.class.getName());

	@RequestMapping(value = "/department", method = { RequestMethod.GET })
	public String department(final HttpServletRequest request,
			final HttpServletResponse response, Map<String, Object> model, ModelMap m) {
		log.info("***Adding department...");

		MessageSource resources = new ClassPathXmlApplicationContext(
				"beans.xml");
		String version = resources.getMessage("curr_version", null, "v0.1.1",
				null);
		String year = resources.getMessage("curr_year", null, "2013", null);
		String app_name = resources.getMessage("app_name", null, "PLM", null);

		model.put("app_name", app_name);
		model.put("version", version);
		model.put("year", year);

		
		
		return "department";
	}
}
