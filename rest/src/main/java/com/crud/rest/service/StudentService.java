package com.crud.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.rest.entity.Student;
import com.crud.rest.repositroy.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student create(Student student) {
		student.getCourses().forEach(course->course.getStudents().add(student));
		
		return studentRepository.save(student);
	}

}
