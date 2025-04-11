package com.crud.rest.controller.com.crud.rest.controller;

import com.crud.rest.entity.EmployeeMember;
import com.crud.rest.service.EmployeeMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/mem")
@Validated
public class EmployeeMemberController {

    @Autowired
    EmployeeMemberService employeeMemberService;

    @PostMapping
    public ResponseEntity<?> saveMem(@Valid @RequestBody EmployeeMember emp){

        return  employeeMemberService.saveEmp(emp);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getMemen(){
        Pageable page = PageRequest.of(0,5);
        Page<EmployeeMember> listPage = employeeMemberService.getAll(page);
        if(listPage.getSize()>0) return ResponseEntity.ok(listPage); else return ResponseEntity.notFound().build();
    }
}
