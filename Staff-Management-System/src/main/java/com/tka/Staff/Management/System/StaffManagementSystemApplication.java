package com.tka.Staff.Management.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EntityScan("com")
@ComponentScan("com")
public class StaffManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffManagementSystemApplication.class, args);
	}

}
