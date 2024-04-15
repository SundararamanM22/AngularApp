package com.prep.angular.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prep.angular.dao.StudentDao;
import com.prep.angular.entity.Student;
import com.prep.angular.exception.AgeAbove18Exception;

@Service
public class StudentService {
	@Autowired
	StudentDao sDao;
	
	Logger log = Logger.getLogger(StudentService.class);
	
	public String setAllStudents(List<Student> students) throws AgeAbove18Exception {
		PropertyConfigurator.configure("log4j.properties");
		long old = students.stream().filter(x -> x.getAge() > 18).count();
		if(old > 0) {
			log.error("ERROR: Student above age 18 found. Please re-enter the correct details!!!");
			throw new AgeAbove18Exception("ERROR: Student above age 18 found. Please re-enter the correct details!!!");
		} else {
			log.info("List of Student objects obtained from Controller and passing through Service towards DAO");
			return sDao.setAllStudents(students);
		}
	}
	
	public List<Student> getAllStudents() {
		log.info("List of Student objects obtained from DAO and passing through Service towards Controller");
		return sDao.getAllStudents();
	}
}
