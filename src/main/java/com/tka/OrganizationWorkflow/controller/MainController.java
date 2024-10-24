package com.tka.OrganizationWorkflow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationWorkflow.entity.Country;
import com.tka.OrganizationWorkflow.entity.Employee;
import com.tka.OrganizationWorkflow.service.MainService;

@RestController
@RequestMapping("API1")
public class MainController {

@Autowired
MainService service;	

@PostMapping("addcountry")
public ResponseEntity<String> addCountry(@RequestBody Country c) {
		String msg=service.addcountry(c);
		return ResponseEntity.ok(msg);
	}

@PutMapping("updatecountry/{id}")
public ResponseEntity<String> updateCountry(@RequestBody Country c,@PathVariable int id) {
	String msg=service.updateCountry(c,id);
	return ResponseEntity.ok(msg);
}

@DeleteMapping("deletecountry/{id}")
public ResponseEntity<String> deleteCountry(@PathVariable int id ) {
	String msg=service.deleteCountry(id);
	return ResponseEntity.ok(msg);
}

@GetMapping("getallcountries")
public ResponseEntity<List<Country>> getAll(){
	List<Country> list=service.getAllCountry();
	return ResponseEntity.ok(list);
}

@GetMapping("getparticularcountry/{id}")
public ResponseEntity<Country> getParticularCountryById(@PathVariable int id){
	Country con=service.getParticularCountryById(id);
	return ResponseEntity.ok(con);
}

@PostMapping("addemployee")
public ResponseEntity<String> addEmployee(@RequestBody Employee e) {
        String msg=service.addEmployee(e);
		return ResponseEntity.ok(msg);
	}

@PutMapping("updateemployee/{id}")
public ResponseEntity<String> updateEmployee(@RequestBody Employee e,@PathVariable long id) {
	String msg=service.updateCountry(e,id);
	return ResponseEntity.ok(msg);
}

@DeleteMapping("deleteemployee/{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable long id ) {
	String msg=service.deleteEmployee(id);
	return ResponseEntity.ok(msg);
}

@GetMapping("getallemployees")
public ResponseEntity<List<Employee>> getAllEmployee(){
	List<Employee> list=service.getAllEmployee();
	return ResponseEntity.ok(list);
}

@GetMapping("getparticularemployee/{id}")
public ResponseEntity<Employee> getParticularEmployeeById(@PathVariable int id){
	Employee emp=service.getParticularEmployeeById(id);
	return ResponseEntity.ok(emp);
}

@PostMapping("login")
public ResponseEntity<Map> Login(@RequestBody Employee emp) {
	Map map=service.Login(emp);
	return ResponseEntity.ok(map);	
}

@GetMapping("salaryrange/{startSal}/{endSal}")
public ResponseEntity<List<Employee>> salaryRange(@PathVariable double startSal, @PathVariable double endSal){
	List<Employee> list=service.salaryRange(startSal,endSal);
	return ResponseEntity.ok(list);
}
}
