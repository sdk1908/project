package com.crud.rest.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.rest.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
