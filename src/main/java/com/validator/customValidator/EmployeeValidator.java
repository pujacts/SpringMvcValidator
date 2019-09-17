package com.validator.customValidator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.validator.vo.Employee;

public class EmployeeValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required" );
		Employee emp=(Employee) obj;
		if(emp.getId()<=0)
		{
			errors.rejectValue("id", "negativeValue", new Object[]{"'id'"},"id can't be negative");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
	}
		
	}


