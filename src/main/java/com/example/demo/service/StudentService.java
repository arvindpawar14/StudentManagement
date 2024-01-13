package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	List<Student> getAllstudent();
	
	Student saveStudent(Student s);
	
	Student getStudentbyId(int id);
	
	Student updateStudent(Student student);
	
	void deleteStudentByid(int id);
	
}