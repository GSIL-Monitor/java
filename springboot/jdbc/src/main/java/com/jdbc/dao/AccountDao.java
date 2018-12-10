package com.jdbc.dao;

import com.jdbc.db.DB;
import com.jdbc.Entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {

    public void insert(Account account) throws SQLException {
        Connection conn = DB.getConnection();
        String sql = "" +
                "insert into account_info (account, amount) values (?,?);";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, account.getAccount());
        ptmt.setDouble(2, account.getAmount());

        ptmt.execute();
    }

    public void update(Account account) throws SQLException {
        Connection conn = DB.getConnection();
        String sql = "" +
                "update account_info set account=?, amount=? where id=?;";
        PreparedStatement ptmt = conn.prepareStatement(sql);


        ptmt.setString(1, account.getAccount());
        ptmt.setDouble(2, account.getAmount());
        ptmt.setInt(3, account.getId());
        ptmt.execute();
    }

    public void delete(Account account) throws SQLException {
        Connection conn = DB.getConnection();
        String sql = "" +
                "delete from account_info where id=?;";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, account.getId());
        ptmt.execute();
    }

    public List<Account> query(Account account) throws SQLException {
        List<Account> result = new ArrayList<Account>();
        Connection conn = DB.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from account_info ");
        sb.append("where account like ?");


        PreparedStatement ptmt = conn.prepareStatement(sb.toString());

        ptmt.setString(1, "%" + account.getAccount() + "%");
        ResultSet rs = ptmt.executeQuery();

        Account a = null;
        while (rs.next()) {
            a = new Account();
            a.setId(rs.getInt("id"));
            a.setAccount(rs.getString("account"));
            a.setAmount(rs.getDouble("amount"));
            a.setCreateDate(rs.getDate("create_at"));
            result.add(a);
        }
        return result;
    }

    public Account get(Integer id) throws SQLException {

        Connection conn = DB.getConnection();
        String sql = "" +
                "select * from account_info " +
                "where id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ResultSet rs = ptmt.executeQuery();

        Account a = null;
        while (rs.next()) {
            a = new Account();
            a.setId(rs.getInt("id"));
            a.setAccount(rs.getString("account"));
            a.setAmount(rs.getDouble("amount"));
            a.setCreateDate(rs.getDate("create_at"));
        }
        return a;
    }
}
