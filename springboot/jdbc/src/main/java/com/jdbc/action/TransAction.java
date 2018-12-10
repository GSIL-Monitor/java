package com.jdbc.action;

import com.jdbc.Service.TransService;
import com.jdbc.dao.AccountDao;
import com.jdbc.Entity.Account;

import java.sql.SQLException;

public class TransAction {
    public static void main(String[] args) {
        try {
            String res = trans();
            System.out.println(res);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String trans() throws SQLException {
        AccountDao accountDao = new AccountDao();
        TransService transService = new TransService();

        Account from = null;
        Account to = null;


        from = accountDao.get(1);
        to = accountDao.get(2);

        return transService.trans(from, to, 10d);
    }
}
