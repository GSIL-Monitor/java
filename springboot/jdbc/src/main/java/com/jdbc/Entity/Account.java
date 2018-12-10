package com.jdbc.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class Account {
    private Integer id;
    private String account;
    private double amount;
    private Date createDate;


}
