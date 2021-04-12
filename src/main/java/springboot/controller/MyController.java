package springboot.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.entity.Employee;

import springboot.service.impl.EmployeeServiceImpl;

@Controller
public class MyController {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	// This is for Fetch Record By Id

	@RequestMapping("/RecordById")
	public String RecordById(Employee employee) {

		return "RecordById";
	}

	@RequestMapping("/dataById")
	public String dataById(@RequestParam("id") long id, Model model) {
		System.out.println("The id is " + id);
		System.out.println(((Object) id).getClass().getName());

		Employee employee = employeeServiceImpl.getEmployeeById(id);

		model.addAttribute("employee", employee);
		System.out.println("The object value is " + employee);

		return "dataByIdForm";
	}

	// end here Fetch Record by Id

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String User(Employee employee) {
		return "showForm";
	}

	@RequestMapping("/addUser")
	public String addUser(Model model, Employee employee) {
		employeeServiceImpl.addUser(employee);
		model.addAttribute("employee", employee);

		return "redirect:signUp";
	}

	@RequestMapping("/contact")
	public String contactPage(Model model) {

		return "contact";
	}

	// for jpa query

	//show data without pagination 
	@RequestMapping(value = "/getData", method = RequestMethod.GET)

	String showData(Model model) {
		List<Employee> list = employeeServiceImpl.getEmp();
		model.addAttribute("employeeList", list);
		return "showData";

	}
	
	// show data with pagination 
	
	//@RequestMapping(value="/getData/{page}", method = RequestMethod.GET)
//		@GetMapping("/getData/{page}")
//	String showData1(@PathVariable("page")Integer page,Model model,Employee employee) {
//		Page<Employee> pp = employeeServiceImpl.getAllEmpPagination(page,3);
//		List <Employee> employeeList = pp.getContent();
//		model.addAttribute("employeeList", employeeList);
//		model.addAttribute("currentpage",page);
//		model.addAttribute("totalPage", pp.getTotalPages());
//		return "showDataPagination";
//
//	}

//		@RequestMapping(value = "/getajaxData", method = RequestMethod.GET)
//
//		String showDataUsingAjax(Model model) {
//			List<Employee> list = employeeServiceImpl.getEmp();
//			model.addAttribute("employeeList", list);
//			return "showDataAjax";
//
//		}
		
		@RequestMapping(value = "/getData/{page}", method = RequestMethod.GET)

		String showDataUsingAjax(@PathVariable("page")Integer page,Model model,Employee employee) {
			Page<Employee> pp = employeeServiceImpl.getAllEmpPagination(page,3);
			List <Employee> employeeList = pp.getContent();
			model.addAttribute("employeeList", employeeList);
			model.addAttribute("currentpage",page);
			model.addAttribute("totalPage", pp.getTotalPages());
			return "showDataAjax";

		}
		
}
