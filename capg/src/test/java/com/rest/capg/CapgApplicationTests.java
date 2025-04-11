package com.rest.capg;

import com.rest.capg.entity.Employee;
import com.rest.capg.repository.EmpRepo;
import com.rest.capg.service.EmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CapgApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Mock
	EmpRepo empRepo;

	@InjectMocks
	EmpService  empService;

	@BeforeEach
	void setUp(){
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testEmpSaveAll(){
		List<Employee> listEmp = Arrays.asList(new Employee(1L,"john",50000,30,"IT"));
		 when(empRepo.saveAll(listEmp)).thenReturn(listEmp);
			List<Employee> resultList = new ArrayList<>();
		 resultList = empService.createEmp(listEmp);
		Assertions.assertNotNull(resultList);
		Assertions.assertEquals(1,resultList.size());
		Assertions.assertEquals("john",listEmp.get(0).getName());
		verify(empRepo,times(1)).saveAll(listEmp);
	}


	@Test
	public void isEmptyTest(){
		List<Employee> listEmp1 = Arrays.asList();
		when(empRepo.saveAll(listEmp1)).thenReturn(listEmp1);
		List<Employee> resultList1 = empService.createEmp(listEmp1);
		Assertions.assertNotNull(resultList1);
		Assertions.assertEquals(0,resultList1.size());
		verify(empRepo,times(1)).saveAll(listEmp1);
	}

	@Test
	public void testGetAllEmployeeWithSorting(){
		List<Employee> listEmp = Arrays.asList(new Employee(1L,"john",10000,60,"HR"),
				new Employee(2L,"sandeep",22000,30,"Development"),
		new Employee(3L,"vineet",50000,34,"IT")
	);

	List<Employee> listEmpRes =	listEmp.stream().sorted((s1,s2)->s1.getDepartment().compareTo(s2.getDepartment())).collect(Collectors.toList());
		System.out.println(listEmpRes);
		Sort sort = Sort.by(Sort.Direction.ASC,"department");
		when(empRepo.findAll(sort)).thenReturn(listEmpRes);
		List<Employee>  listResult = empService.getAllWithSort(sort);
		System.out.println("::"+listResult);
		Assertions.assertNotNull(listEmpRes);
		Assertions.assertEquals(listEmpRes,listResult);
		Assertions.assertEquals("Development",listEmpRes.get(0).getDepartment());
		Assertions.assertEquals("HR",listEmpRes.get(1).getDepartment());
		Assertions.assertEquals("IT",listEmpRes.get(2).getDepartment());
		Assertions.assertEquals(3,listResult.size());
		verify(empRepo,times(1)).findAll(sort);
	}
}
