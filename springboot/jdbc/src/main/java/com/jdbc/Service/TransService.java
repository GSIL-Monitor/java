package com.jdbc.Service;

import com.jdbc.dao.AccountDao;
import com.jdbc.dao.TransInfoDao;
import com.jdbc.db.DB;
import com.jdbc.Entity.Account;
import com.jdbc.Entity.TransInfo;

import java.sql.Connection;
import java.sql.SQLException;

public class TransService {
    public String trans(Account from, Account to, Double amount) throws SQLException {
        Connection conn=DB.getConnection();
        conn.setAutoCommit(false);   //事务  关闭自动提交

        try {
            AccountDao accountDao = new AccountDao();
            TransInfoDao transInfoDao = new TransInfoDao();

            from.setAmount(from.getAmount() - amount);
            accountDao.update(from);

            to.setAmount(to.getAmount() + amount);
            accountDao.update(to);

            TransInfo info = new TransInfo();
            info.setSource_account(from.getAccount());
            info.setSource_id(from.getId());
            info.setDestination_account(to.getAccount());
            info.setDestination_id(to.getId());
            info.setAmount(amount);
            transInfoDao.insert(info);

            conn.commit(); //事务  如果以上代码运行都正常则手动提交

            return "success";
        } catch (Exception e) {
            conn.rollback();   //事务   如果以上代码有报错则回滚
            e.printStackTrace();
            return "fail";
        }

    }
}
