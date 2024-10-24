package com.tka.OrganizationWorkflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationWorkflow.dao.MainDao;
import com.tka.OrganizationWorkflow.entity.Country;
import com.tka.OrganizationWorkflow.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	
	public String addcountry(Country c) {
		String msg=dao.addcountry(c);
		if(Objects.isNull(msg)) {
			msg="Country is not Added";
		}
		return msg;
	}

	public String updateCountry(Country c, int id) {
	String msg=dao.upadatecountry(c,id);
	
	if(Objects.isNull(msg)) {
		msg="Country is not Updated";
	}
	return msg;
}

	public String deleteCountry(int id) {
		String msg=dao.deleteCountry(id);
		
		if(Objects.isNull(msg)) {
			msg="Country is not Deleted";
		}
		return msg;
	}

	public List<Country> getAllCountry() {
		List<Country> list=dao.getAllCountry();
		return list;
	}

	public Country getParticularCountryById(int id) {
		Country con=dao.getParticularCountryById(id);
		return con;
	}

	public String addEmployee(Employee e) {
		String msg=dao.addEmployee(e);
		if(Objects.isNull(msg)) {
			msg="Employee is not Added";
		}
		return msg;
	}

	public String updateCountry(Employee e, long id) {
		String msg=dao.upadatecountry(e,id);
		
		if(Objects.isNull(msg)) {
			msg="Employee is not Updated";
		}
		return msg;
	}

	public String deleteEmployee(long id) {
        String msg=dao.deleteEmployee(id);
		
		if(Objects.isNull(msg)) {
			msg="Employee is not Deleted";
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> list=dao.getAllEmployee();
		return list;
	}

	public Employee getParticularEmployeeById(int id) {
        Employee emp=dao.getParticularEmployeeById(id);
		return emp;
	}

	public Map Login(Employee emp) {
		Employee obj=dao.Login(emp);
		Map map=new HashMap();
		if(Objects.isNull(obj)) {
			map.put("msg","invalid user");
			map.put("user", obj);
		}else {
			map.put("msg","Valid user");
			map.put("user", obj);
		}
		return map;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {
		List<Employee> list= dao.salaryRange(startSal,endSal);

		return list;
	}

}
