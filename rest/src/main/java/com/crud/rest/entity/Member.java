package com.crud.rest.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long mid;
	
	private String memName;

	@Override
	public String toString() {
		return "Member{" +
				"mid=" + mid +
				", memName='" + memName + '\'' +
				", emp=" + emp +
				'}';
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	@JsonBackReference
	EmployeeMember emp;

	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public EmployeeMember getEmp() {
		return emp;
	}

	public void setEmp(EmployeeMember emp) {
		this.emp = emp;
	}
}
