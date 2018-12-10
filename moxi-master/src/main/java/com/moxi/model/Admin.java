package com.moxi.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Admin extends BaseObject {

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



}
