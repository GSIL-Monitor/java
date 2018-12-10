package com.moxi.model;

import lombok.Data;

import java.sql.Date;

@Data
public class News extends BaseObject {

	private long id;
	private String title;
	private String description;
	private long category;
	private String categoryName;
	private String categoryImage;
	private String image;
	private String content;
	private Date addDate;
	private Date updateDate;
	private int state;
	private int commendState;

	private int browses;
	private int likes;
	private int comments;
	private int score;



}
