package com.validator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.validator.customValidator.EmployeeValidator;
import com.validator.vo.Employee;

@Controller
public class EmployeeController {

	//private static final Logger logger = LoggerFactory.
	//@Autowired
	EmployeeValidator empValidator=new EmployeeValidator();
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(empValidator);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="employee/save")
	public String getEmployee(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "empSave";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="employee/save")
	public String saveEMployee(@ModelAttribute("employee") @Validated Employee employee,BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			//logger.in
			return "empSave";
		}
		model.addAttribute("emp",employee);
		return "empSaveSuccess";
	}
}
