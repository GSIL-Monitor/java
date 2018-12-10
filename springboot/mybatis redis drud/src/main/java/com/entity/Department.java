package com.entity;

import lombok.Data;

@Data
public class Department {
	private Integer id;
	private String departmentName;


	public Department() {
	}

	public Department(Integer id, String departmentName) {
		this.id = id;
		this.departmentName = departmentName;
	}
}
