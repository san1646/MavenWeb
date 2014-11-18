package main.java.com.plm.controller;

import java.util.ArrayList;
import java.util.List;

import main.java.com.plm.model.User;
import main.java.com.plm.validators.ValidationResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
	private List<User> userList = new ArrayList<User>();

	@RequestMapping(value="/AddUser",method=RequestMethod.GET)
	public String showForm(){
		return "AddUser";
	}

	@RequestMapping(value="/AddUser",method=RequestMethod.POST)
	public @ResponseBody ValidationResponse addUser(@ModelAttribute(value="user") User user, BindingResult result ){
		ValidationResponse res = new ValidationResponse();
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "name", "Hours can not be empty.");
		ValidationUtils.rejectIfEmpty(result, "education", "Education not be empty");
		
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

}
