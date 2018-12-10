package com.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Employee implements Serializable {
	private Integer id;
	private String lastName;
	private String email;
	private Integer gender;
	private Department department;
	private Date birth;


	public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}


	public Employee() {
	}
}
