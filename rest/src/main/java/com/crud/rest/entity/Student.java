package com.crud.rest.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@javax.persistence.Entity
@Setter
@Getter
public class Student {

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="Student firstName is mandatory")
	@javax.validation.constraints.Size(min=2,max=10,message="Student firstName must be between 2 and 10 characters")
	private String firstName;
	
	private String lastName;
	
	@javax.persistence.ManyToMany(cascade=javax.persistence.CascadeType.ALL)
	//@ManyToMany(cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@javax.persistence.JoinTable(name="student_course",joinColumns=@javax.persistence.JoinColumn(name="student_id"),
	inverseJoinColumns=@javax.persistence.JoinColumn(name="course_id")
			)
	
	private Set<Course> courses = new HashSet<Course>();


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}


	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	} 
	
	/*public void addCourse(Course course) {
		this.courses.add(course);
		course.getStudents().add(this);
	}*/
}
	
