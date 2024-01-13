package com.example.demo.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImp implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImp(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllstudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student s) {

		return studentRepository.save(s);
	}

	@Override
	public Student getStudentbyId(int id) {
		return studentRepository.findById(id).get();

	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentByid(int id) {
		studentRepository.deleteById(id);
	}
}