package com.moxi.model;

import lombok.Data;

import java.sql.Date;

@Data
public class NewsCategory extends BaseObject {

	private long id;
	private String name;
	private String description;
	private String image;
	private Date addDate;
	private int state;


}
