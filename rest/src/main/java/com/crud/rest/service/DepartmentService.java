package com.crud.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.rest.entity.Department;
import com.crud.rest.entity.Employee;
import com.crud.rest.repositroy.DepartmentRepository;


@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository dpartmentRepository;
	
	
	public Department createEmp(Department dept) {
			dept.getEmployees().stream().forEach(s->System.out.println(s.toString()+"teesr"));
	for(Employee employee : dept.getEmployees()) {
		employee.setDepartment(dept);
	}
	
		return dpartmentRepository.save(dept);
	}
	
}
