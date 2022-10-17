package com.example.projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MyController {
	@Autowired
EmployeeService service;
	
	@RequestMapping("/")
	public String showHomePage(Model model)
	{
		System.out.println("Display called");
		List<Employee>list =service.displayData();
		for(Employee e : list)
		{
			System.out.println(e.getId()+" "+e.getName()+" "+e.getDept());
		}
	   model.addAttribute("xyz",list);		
		return "show";
	}	
	@RequestMapping("/addData")
	public String newData (Model model)
	{
	Employee employee= new Employee();
	model.addAttribute("employee",employee);	
	return "add_Pro";
	}
	
	@RequestMapping(value="/save",method =RequestMethod.POST)
	
	public String saveAfter (@ModelAttribute("employee")  Employee employee)
	{
		service.saveEmployee(employee);
		return "redirect:/";
		
	}
	
	@RequestMapping("/edit/{id}")
   public ModelAndView editData(@PathVariable(name="id")long id)
   {
		ModelAndView View =new 	ModelAndView("edit_data");
		Employee employee = service.getPro(id);
	    View.addObject("employee",employee);
	    return View;
		
   }
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable(name = "id")long id)
	{
		service.delete(id);
		return "redirect:/";
	}
	
}
