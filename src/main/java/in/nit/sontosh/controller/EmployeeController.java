package in.nit.sontosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import in.nit.sontosh.model.Employee;
import in.nit.sontosh.service.EmployeeService;
import in.nit.sontosh.validate.CaptchaValidator;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	@Autowired
	private CaptchaValidator validator;

	// 1. show the register page
	@GetMapping("/register")
	public String showReg(Model model) {
		model.addAttribute("employee", new Employee());
		return "EmpReg";

	}

	// 2. save data on submit
	@PostMapping("/save")
	public String save(@ModelAttribute Employee employee, @RequestParam("g-recaptcha-response") String captcha,
			Model model)
	{
		
				if(validator.isValid(captcha)) {
			Integer id = service.createEmployee(employee);
			model.addAttribute("message", "Employee '" + id + "' saved");
			model.addAttribute("employee", new Employee());
		}else {
			model.addAttribute("message","Please Validate Captcha!!");
			
		}
				return "EmpReg";
	}

	// 3. display all record
	@GetMapping("/all")
	public String fetchAll(Model model) {
		List<Employee> list = service.getAllEmployee();
		model.addAttribute("list", list);
		return "EmpData";

	}

}
