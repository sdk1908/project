package com.rest.capg.controller;

import com.rest.capg.entity.Employee;
import com.rest.capg.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpController {

        @Autowired
        EmpService empService;

        @PostMapping
        public ResponseEntity<?> save(@RequestBody List<Employee> list){
            List<Employee> empList = empService.createEmp(list);
            return ResponseEntity.ok(empList);
        }

        @GetMapping("/get")
        public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size,@RequestParam(defaultValue="name") String sortBy){

            PageRequest pageRequest = PageRequest.of(page,size,Sort.by(Sort.Direction.DESC,"salary"));
            Page<Employee> pages = empService.getAllEmp(pageRequest);
            if(pages.isEmpty())
             return    ResponseEntity.notFound().build();
            else
                return  ResponseEntity.ok(pages.getContent());
        }

        @GetMapping("/getAll")
        public ResponseEntity<?> getAllWithSort(@RequestParam(defaultValue = "salary") String field,@RequestParam(defaultValue = "asc") String order){

        List<Employee> listEmp;
            if(order.equalsIgnoreCase("asc"))
                listEmp = empService.getAllWithSort(Sort.by(Sort.Direction.ASC,field));
            else
                listEmp = empService.getAllWithSort(Sort.by(Sort.Direction.DESC,field));

            if(!listEmp.isEmpty() && listEmp.size()>0)
                return ResponseEntity.ok(listEmp);
            else
                return ResponseEntity.notFound().build();
        }
	
}
