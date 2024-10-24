package com.tka.OrganizationWorkflow.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationWorkflow.entity.Country;
import com.tka.OrganizationWorkflow.entity.Employee;

@Repository
public class MainDao {

@Autowired
SessionFactory factory;
	
public String addcountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg="Country added Successfully";
		}
		catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally{
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

public String upadatecountry(Country c, int id) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	Country country=null;
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		country=session.get(Country.class, id);
		country.setCname(c.getCname());
		session.merge(country);
		tx.commit();
		msg="Country Updated Successfully";
	}
	catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}
	finally{
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;

}

public String deleteCountry(int id) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	Country country=null;
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		country=session.get(Country.class, id);
		session.remove(country);
		tx.commit();
		msg="Country Deleted Successfully";
	}
	catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}
	finally{
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;

}

public List<Country> getAllCountry() {
	
	Session session=null;
	Transaction tx=null;
	List<Country> list=null;
	String hqlquery="from Country";
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		Query<Country> query=session.createQuery(hqlquery,Country.class);
		list=query.list();
		tx.commit();
		
	}
	catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}
	finally{
		if(session!=null) {
			session.close();
		}
	}
	
	return list;

}

public Country getParticularCountryById(int id) {
	Session session=null;
	Transaction tx=null;
	Country country=null;
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		country=session.get(Country.class, id);
		tx.commit();
		
	}
	catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}
	finally{
		if(session!=null) {
			session.close();
		}
	}
	
	return country;

}

public String addEmployee(Employee e) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		session.persist(e);
		tx.commit();
		msg="Employee added Successfully";
	}
	catch (Exception er) {
		if(tx!=null) {
			tx.rollback();
		}
		er.printStackTrace();
	}
	finally{
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;
}

public String upadatecountry(Employee e, long id) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	Employee emp=null;
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		emp=session.get(Employee.class, id);
		emp.setName(e.getName());
		emp.setStatus(e.getStatus());
		emp.setDepartment(e.getDepartment());
		emp.setMobileno(e.getMobileno());
		emp.setEmailid(e.getEmailid());
		emp.setCreatedBy(e.getCreatedBy());
		emp.setCreatedDate(e.getCreatedDate());
		emp.setUpdatedBy(e.getUpdatedBy());
		emp.setUpdatedDate(e.getUpdatedDate());
		emp.setSalary(e.getSalary());
		emp.setCountry(e.getCountry());
		session.merge(emp);
		tx.commit();
		msg="Employee Updated Successfully";
	}
	catch (Exception er) {
		if(tx!=null) {
			tx.rollback();
		}
		er.printStackTrace();
	}
	finally{
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;

}

public String deleteEmployee(long id) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	Employee emp=null;
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		emp=session.get(Employee.class, id);
		session.remove(emp);
		tx.commit();
		msg="Employee Deleted Successfully";
	}
	catch (Exception er) {
		if(tx!=null) {
			tx.rollback();
		}
		er.printStackTrace();
	}
	finally{
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;

}

public List<Employee> getAllEmployee() {

	Session session=null;
	Transaction tx=null;
	List<Employee> list=null;
	String hqlquery="from Employee";
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		Query<Employee> query=session.createQuery(hqlquery,Employee.class);
		list=query.list();
		tx.commit();
		
	}
	catch (Exception er) {
		if(tx!=null) {
			tx.rollback();
		}
		er.printStackTrace();
	}
	finally{
		if(session!=null) {
			session.close();
		}
	}
	
	return list;
}

public Employee getParticularEmployeeById(int id) {
	Session session=null;
	Transaction tx=null;
	Employee emp=null;
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		emp=session.get(Employee.class, id);
		tx.commit();
		
	}
	catch (Exception er) {
		if(tx!=null) {
			tx.rollback();
		}
		er.printStackTrace();
	}
	finally{
		if(session!=null) {
			session.close();
		}
	}
	
	return emp;
}

public Employee Login(Employee emp) {
	Session session=null;
	Transaction tx=null;
	Employee employee=null;
	String hqlquery="from Employee where emailid=:emailid and mobileno=:mobileno";
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		Query<Employee> query=session.createQuery(hqlquery,Employee.class);
		query.setParameter("emailid",emp.getEmailid() );
		query.setParameter("mobileno",emp.getMobileno());
		employee=query.uniqueResult();
		tx.commit();
	}
	catch (Exception er) {
		if(tx!=null) {
			tx.rollback();
		}
		er.printStackTrace();
	}
	finally{
		if(session!=null) {
			session.close();
		}
	}
	
	return employee;
}

public List<Employee> salaryRange(double startSal, double endSal) {
	Session session=null;
	Transaction tx=null;
    List<Employee> list=null;	
   String hqlquery="from Employee where salary between :startSal and :endSal";
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query=session.createQuery(hqlquery,Employee.class);
			query.setParameter("startSal", startSal);
			query.setParameter("endSal", endSal);
			list=query.list();
			tx.commit();
			
		}catch(Exception er){
			if (tx!=null) {
				tx.rollback();
			}
			er.printStackTrace();	
		}finally{
			if(session!=null) {
				session.close();
			}
			
		}
		
		return list;	
}


}

