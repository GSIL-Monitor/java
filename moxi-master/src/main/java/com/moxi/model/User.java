package com.moxi.model;

import lombok.Data;

import java.sql.Date;

@Data
public class User {

	private long id;
	private String userName;
	private String password;
	private String realName;
	private int age;
	private String phoneNumber;
	private String headPicture;
	private Date addDate;
	private Date updateDate;
	private int state;

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", realName=" + realName
				+ ", age=" + age + ", phoneNumber=" + phoneNumber + ", headPicture=" + headPicture + ", addDate="
				+ addDate + ", updateDate=" + updateDate + ", state=" + state + "]";
	}



}
