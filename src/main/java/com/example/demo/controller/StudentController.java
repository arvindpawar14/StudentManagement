package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllstudent());
		return "students";
	}

	@GetMapping("/students/new")
	public String CreateStudentForm(Model model) {
		// create hold object to hold Student Object Data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student s) {
		studentService.saveStudent(s);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", studentService.getStudentbyId(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
		Student existingStudent = studentService.getStudentbyId(id);
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());

		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudentByid(id);
		return "redirect:/students";
	}

}
