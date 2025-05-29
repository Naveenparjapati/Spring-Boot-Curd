package com.example.Boot_crud.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.Boot_crud.entity.Student;
import com.example.Boot_crud.repository.StudentRepository;

@Service
public class CrudService {
	
	@Autowired
	StudentRepository repository;
	
	public String insert(Student student,Model model)
	{
		repository.save(student);
		model.addAttribute("message","Data storeed succesfuly");
		return "Home.html";
	}

	public String fetch(Model model) {
		// TODO Auto-generated method stub
	List<Student> students=repository.findAll();
	if(students.isEmpty())
	{
		model.addAttribute("message","No record found");
		return "Home.html";
	}
	else {
		model.addAttribute("student",students);
		return "fetch.html";
	}
	}
	
	public String fetch(Model model, String search) {
		HashSet<Student>students = new HashSet<Student>();
		try {
			long num = Long.parseLong(search);
			students.addAll(repository.findByMobile(num));
		} catch (NumberFormatException e) {
			students.addAll(repository.findByNameLike("%" + search + "%"));
			students.addAll(repository.findByEmailLike("%" + search + "%"));
		}
		if (students.isEmpty()) {
			model.addAttribute("message", "No records Found");
			return "home.html";
		} else {
			model.addAttribute("students", students);
			return "fetch.html";
		}
	}


	public String delete(int id,Model model)
	{
		repository.deleteById(id);
		model.addAttribute("message", "Deleted succ");
		return "Home.html";
	}

	public String edit(int id, Model model) {
		// TODO Auto-generated method stub
		Student student = repository.findById(id).orElseThrow();
		model.addAttribute("student", student);
		return "edit.html";
	}
	
	public String udateProduct(Student student, Model model) {
		// TODO Auto-generated method stub
		repository.save(student);
		model.addAttribute("message", "Record Updated Success");
		return "home.html";
	}
	
}
