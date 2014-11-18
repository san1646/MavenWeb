package main.java.com.plm.controller;

import javax.servlet.http.HttpSession;

import main.java.com.plm.form.KnightedWBSTechnologyForm;
import main.java.com.plm.service.TechnologyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

	
		@Autowired
    	private TechnologyService technologyService;
	
		static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomeController.class.getName());

		@RequestMapping(value = "/dashboard", method=RequestMethod.GET)
		public String submitKnightedWBS(Model model, HttpSession session){
			
			return "dashboard";
		}
}
