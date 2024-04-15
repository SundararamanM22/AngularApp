package com.prep.angular.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prep.angular.entity.Student;
import com.prep.angular.repository.StudentRepository;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository sRepo;
	
	Logger log = Logger.getLogger(StudentDao.class);
	
	public String setAllStudents(List<Student> students) {
		sRepo.saveAll(students);
		log.info("List of Student objects obtained from Service and passing through DAO into database");
		return "Saved all successfully";
	}
	
	public List<Student> getAllStudents() {
		log.info("List of Student objects obtained from database and passing through DAO towards Service");
		return sRepo.findAll();
	}
}
