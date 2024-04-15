package com.prep.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prep.angular.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
