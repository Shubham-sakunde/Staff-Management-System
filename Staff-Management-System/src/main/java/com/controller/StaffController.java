package com.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entities.Staff;



@RestController
public class StaffController {
	
	@Autowired
	SessionFactory factory;
	
	
//	Q1] 1. Write an api to get all the staff record.
	
	@GetMapping("getAllStaff")
	public List<Staff> getAllStaff() {
		
		Session session = factory.openSession();
		Query query = session.createQuery("from Staff");
		
		List<Staff> list = query.list();
		
		return list;
	}
	
//Q2]  Write an api to get record whose staffed is 3.

	@RequestMapping("getStaffMember/{staffid}")
	public Staff getStaffMember(@PathVariable int staffid) {
		
		Session session = factory.openSession();
		Staff staffMember = session.get(Staff.class, staffid);
		
		return staffMember;
		
	}
	
//Q3]  Write an api to insert one staff member in table.
	
	@PostMapping("addStaffMember")
	public String addStaffMember(@RequestBody Staff staff) {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(staff);
		tx.commit();
		session.close();
		
		return "Staff member added";
		
	}
	
//Q4] Write an api to get the list of staff who is/are having salary more than 20,000.
	
	@GetMapping("getStaffSalaryMoreThan/{salary}")
	public List<Staff> getStaffSalaryMoreThan(@PathVariable int salary){
		
		Session session = factory.openSession();
		Query query = session.createQuery("from Staff where salary >=:salary");
		query.setParameter("salary",salary);
		List<Staff> list = query.list();
		
		return list;
		
	}
	
//Q5] Write an api to get the lit of staff who is/are having the experience between 10k to 20k.	
	
	@GetMapping("getStaffSalaryBetween/{salaryStart}/{salaryUpto}")
	public List<Staff> getStaffSalaryBetween(@PathVariable int salaryStart,@PathVariable int salaryUpto){
		
		Session session = factory.openSession();
		Query query = session.createQuery("from Staff where salary between :salaryStart and :salaryUpto");
		query.setParameter("salaryStart", salaryStart);
		query.setParameter("salaryUpto",salaryUpto);
		List<Staff> list = query.list();
		return list;
	}
	
//Q6] Write an api to get staff information who is having max salary.	
	
	@RequestMapping("getStaffSalaryMax")
	public List getStaffSalaryMax() {
		
		Session session = factory.openSession();
		Query query = session.createQuery("from Staff where salary=(select max(salary) from Staff)");
		List<Staff> list = query.list();
		return list;
		
	}
	
//Q7] Write an api to update the salary for staff whose id is 4. 
	
	@PatchMapping("updateSalary/{staffid}")
	public String updateSalary(@PathVariable int staffid) {
		Session session = factory.openSession();
		Query query = session.createQuery("update Staff set salary=:salary where staffid=:staffid");
		query.setParameter("salary",100000);
		query.setParameter("staffid",staffid);
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		session.close();
		return "salary updated to 100000";
		
	} 
	
//Q8] Write an api to get the staff staff name (not all information) who is having minimum experience.	
	
	@GetMapping("getStaffWithMinExperience")
	public String getStaffWithMinExperience() {
		
		Session session = factory.openSession();
		Query query = session.createQuery("from Staff where experience=(select min(experience) from Staff)");
		List<Staff> list = query.list();
		Staff minExStaff  = list.get(0);
		String name = minExStaff.name;
		
		return name;
	}
	
//Q9] Write an api to get the list of staff whose are having profile as a trainer.
	
	@GetMapping("getTrainerProfileStaff")
	public List getTrainerProfileStaff() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Staff where profile=:profile");
		
		query.setParameter("profile","trainer");
		List list = query.list();
		return list;
		
	}
	
//Q10] Write an api to get the list of staff, whose not having profile as a trainer.	
	
	@GetMapping("getStaffrofileExceptTrainer")
	public List getStaffProfileExceptTrainer() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Staff where profile !=:profile");
		
		query.setParameter("profile","trainer");
		List list = query.list();
		return list;
		
	}
	
	
	
}
