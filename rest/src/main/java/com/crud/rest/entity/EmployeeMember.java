package com.crud.rest.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NonNull;

@Entity
public class EmployeeMember {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@NotBlank
	@Size(min = 2,max=20)
	private String name;
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "EmployeeMember [id=" + id + ", name=" + name + ", age=" + age + ", listMem=" + listMem + "]";
	}

	public int getAge() {
		return age;
	}

	public Set<Member> getListMem() {
		return listMem;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setListMem(Set<Member> listMem) {
		this.listMem = listMem;
	}

	private int age;
	@JsonManagedReference
	@OneToMany(mappedBy="emp",orphanRemoval = true,cascade=CascadeType.ALL)
	Set<Member> listMem;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EmployeeMember that = (EmployeeMember) o;
		return Objects.equals(id, that.id) && name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
