package main.java.com.plm.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils; 


public class TechnologyValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
	
}
