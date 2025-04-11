package com.crud.rest.controller;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.entity.Student;
import com.crud.rest.service.StudentService;


@RestController
@RequestMapping("/api/students")
@Validated
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping
	public ResponseEntity<?> createStudent(@javax.validation.Valid @RequestBody Student student){
		
		Student stud = studentService.create(student);
		return ResponseEntity.status(201).body(student);
		
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<?> getCity
	( @PathVariable  @Pattern(regexp = "meruut|mumbai",message="Only merrut & mumbsi allowed") String city){
		
			return ResponseEntity.status(200).body("city:"+city);
		
	}
	
	

}
