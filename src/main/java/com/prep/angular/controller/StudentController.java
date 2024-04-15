package com.prep.angular.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prep.angular.entity.Student;
import com.prep.angular.exception.AgeAbove18Exception;
import com.prep.angular.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService sSer;
	
	Logger log = Logger.getLogger(StudentController.class);
	
	@PostMapping(value = "/setAllStudents")
	public String setAllStudents(@RequestBody List<Student> students) throws AgeAbove18Exception {
		PropertyConfigurator.configure("log4j.properties");
		log.info("List of Student objects obtained from UI and passing through controller towards Service");
		return sSer.setAllStudents(students);
	}
	
	@GetMapping(value = "/getAllStudents")
	public List<Student> getAllStudents() {
		PropertyConfigurator.configure("log4j.properties");
		log.info("List of Student objects obtained from Service and passing through controller towards UI");
		return sSer.getAllStudents();
	}
}
