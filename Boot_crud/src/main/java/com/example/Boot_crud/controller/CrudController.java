package com.example.Boot_crud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Boot_crud.entity.Student;
import com.example.Boot_crud.service.CrudService;

@Controller
public class CrudController {

	@Autowired
	CrudService  service;
	  
	@GetMapping("/")
	public String loadHome()
	{
		return "Home.html";
	}
	
	@GetMapping("/insert")
	public String loadInsert()
	{
		return "add.html";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute Student student,Model model)
	{
		return service.insert(student,model);
	}
	
	@GetMapping("/fetch")
	 public String fetch(Model model, @RequestParam(defaultValue = "")String search) {
		 return service.fetch(model,search);
	 }
	
	@GetMapping("/delete/{id}")
	 public String delete(@PathVariable int id,Model model) {
		 return service.delete(id,model);
	 }
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model model) {
		return service.edit(id,model);
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Student student,Model model) {
		return service.udateProduct(student,model);
	}	
}
