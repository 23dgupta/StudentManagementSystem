package com.cognizant.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.student.entity.StudentEntity;
import com.cognizant.student.service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	StudentServiceImpl studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld() {

		return "Welcome to Spring Boot";
	}

	// http://localhost:9090/addStudent
	@PostMapping("/addStudent")
	public Integer createStudent(@RequestBody StudentEntity student) {

		Integer id = studentService.saveStudent(student);

		return id;

	}

	@GetMapping("/allstudents")
	public List<StudentEntity> getStudent() {

		return studentService.getAllStudents();
	}

	// http://localhost:9090/student/4

	@GetMapping("/student/{id}")
	public Optional<StudentEntity> getStudent(@PathVariable Integer id) {
		return studentService.getStudent(id);
	}

	@DeleteMapping("/deletStudent/{id}")
	public ResponseEntity<StudentEntity> deleteStudent(@PathVariable Integer id) {

		ResponseEntity<StudentEntity> studentEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			studentService.deleteStudent(id);
		} catch (Exception e) {
			e.printStackTrace();
			studentEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return studentEntity;
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<StudentEntity> updateStudent(@PathVariable Integer id,@RequestBody StudentEntity student) {
		
		ResponseEntity<StudentEntity> studentEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			studentService.updateStudent(student, id);
		} catch (Exception e) {
			e.printStackTrace();
			studentEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return studentEntity;
	}
	
}
