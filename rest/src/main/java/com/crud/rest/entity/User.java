package com.crud.rest.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class User  {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;
    
    private String role;

    private String username;
    private String password;
    @Column(name="created_By")
    private String createdBy;

    @Column(name="updated_By")
    private String updatedBy;

    @CreatedDate
    private Date createdDate = new Date();
    private Date updatedDate;

    @OneToOne(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    Profile profile;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate 
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

}
