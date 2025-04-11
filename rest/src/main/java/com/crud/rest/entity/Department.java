package com.crud.rest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@javax.persistence.Entity
public class Department {

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	private long deptId;
	
	@Column(unique = true)
	private String name;
	
	@javax.persistence.OneToMany(mappedBy="department",cascade=javax.persistence.CascadeType.ALL,orphanRemoval=true)
	List<Employee> employees = new ArrayList<Employee>();

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + "]";
	}
	
}
