package com.rest.capg.service;

import com.rest.capg.entity.Employee;
import com.rest.capg.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class EmpService {

	@Autowired
    EmpRepo empRepo;

	public List<Employee> createEmp(List<Employee> emp){
	    List<Employee> list = empRepo.saveAll(emp);
	    return list;
    }

    public Page<Employee> getAllEmp(PageRequest page){

		return  empRepo.findAll(page);
    }

    public List<Employee> getAllWithSort(Sort sort){
		return empRepo.findAll(sort);
	}

}
