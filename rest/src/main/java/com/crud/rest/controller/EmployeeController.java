package com.crud.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.entity.Department;
import com.crud.rest.service.DepartmentService;


@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/createdept")
	@Transactional
    public ResponseEntity<Department> saveEmp(@RequestBody Department dept){
		
			Department deptm = departmentService.createEmp(dept);   
		return ResponseEntity.status(201).body(deptm);
    }
	
	@PutMapping("/emp_update")
	public ResponseEntity<?> updateEmp(@RequestBody Department dept ){
		return null;
	}
}

