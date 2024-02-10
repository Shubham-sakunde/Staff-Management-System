package com.tka.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Staff {
	
	@Id
	public String staffid;
	public String name;
	public String profile;
	public int salary;
	public int experience;
	
	
	public Staff() {
		
	}
	
	public Staff(String staffid,String name,String profile,int salary,int experience) {
		
		this.staffid = staffid;
		this.name = name;
		this.profile = profile;
		this.salary = salary;
		this.experience = experience;
		
	}
	
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
	@Override
	public String toString() {
		return "Staff [staffid=" + staffid + ", name=" + name + ", profile=" + profile + ", salary=" + salary
				+ ", experience=" + experience + "]";
	}
	

}
