package com.crud.rest.repositroy;

import com.crud.rest.entity.EmployeeMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeMemberRepo extends JpaRepository<EmployeeMember,Long> {

    public Optional<EmployeeMember> findByIdOrName(Long id, String name);

}
