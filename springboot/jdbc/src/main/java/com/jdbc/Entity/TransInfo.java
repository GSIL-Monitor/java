package com.jdbc.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class TransInfo {
    private Integer id;
    private Integer source_id;
    private String source_account;
    private Integer destination_id;
    private String destination_account;
    private double amount;
    private Date createDate;


}
