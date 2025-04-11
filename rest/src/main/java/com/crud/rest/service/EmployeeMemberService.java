package com.crud.rest.service;

import com.crud.rest.entity.EmployeeMember;
import com.crud.rest.repositroy.EmployeeMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeMemberService {

    @Autowired
    EmployeeMemberRepo employeeMemberRepo;

    public ResponseEntity<?> saveEmp(EmployeeMember employeeMember){
        Optional<EmployeeMember> existEmp =
                employeeMemberRepo.findByIdOrName(employeeMember.getId(),employeeMember.getName());

        if(existEmp.isPresent()){
            return	ResponseEntity.ok("Employee already exist");
        }
        else{
            employeeMemberRepo.save(employeeMember);

            Optional<EmployeeMember> empMem= employeeMemberRepo.findById(employeeMember.getId());

            if(empMem.get() != null)
                return ResponseEntity.status(201).body("saved data successfully");
            else
                return ResponseEntity.notFound().build();
        }



        //   return employeeMemberRepo.save(employeeMember);
    }

    public Page<EmployeeMember> getAll(Pageable page){
        Page<EmployeeMember> page1 =   employeeMemberRepo.findAll(page);
        return page1;
    }

}
