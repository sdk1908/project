package com.crud.rest.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long profileId ;

    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNo;
    private String address;

    @OneToOne
    @JoinColumn(name="userId",referencedColumnName="userId",nullable=false)
    @JsonBackReference
    User user;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(profileId, other.profileId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(profileId);
	}
}
