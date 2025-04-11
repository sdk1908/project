package com.crud.rest.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.rest.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
