package com.zmo.rest_application.controller;

import com.zmo.rest_application.model.Student;
import com.zmo.rest_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@GetMapping
	public String index() {
		return "Welcome to rest api";
	}

	//add student
	@PostMapping("/add")
	public Student saveStudent(@RequestBody Student student){
		return studentService.addStudent(student);
	}
	//get all student
	@GetMapping("/all")
	public List<Student> getAllStudent(){
		return studentService.findAllStudent();
	}
	//get student by id
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id){
		return studentService.findStudentById(id);
	}
	//update student
	@PutMapping("/update/{id}")
	public void modifyStudentById(@PathVariable Long id,@RequestBody Student student){
		Student reqStudent=studentService.findStudentById(id);
		reqStudent.setName(student.getName());
		reqStudent.setFname(student.getFname());
		reqStudent.setDob(student.getDob());
		reqStudent.setGender(student.getGender());
		reqStudent.setGrade(student.getGrade());
		reqStudent.setContact(student.getContact());
		reqStudent.setAddress(student.getAddress());

		studentService.updateStudent(reqStudent);
	}
	//delete student
	@DeleteMapping("/delete/{id}")
	public void eraseStudentById(@PathVariable Long id){
		studentService.deleteStudent(id);
	}
}
