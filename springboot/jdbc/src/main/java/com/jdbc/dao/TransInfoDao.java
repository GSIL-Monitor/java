package com.jdbc.dao;

import com.jdbc.db.DB;
import com.jdbc.Entity.TransInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransInfoDao {


    public void insert(TransInfo transInfo) throws SQLException {

        Connection conn = DB.getConnection();
        String sql ="" +
                "insert into trans_info (source_id, source_account, destination_id, " +
                "destination_account, amount) values (?,?,?,?,?);";
        PreparedStatement ptmt = conn.prepareStatement(sql);

       ptmt.setInt(1, transInfo.getSource_id());
       ptmt.setString(2, transInfo.getSource_account());
       ptmt.setInt(3, transInfo.getDestination_id());
       ptmt.setString(4, transInfo.getDestination_account());
       ptmt.setDouble(5, transInfo.getAmount());

       ptmt.execute();
    }

    public void update(TransInfo transInfo) throws SQLException {
        Connection conn = DB.getConnection();
        String sql ="" +
                "update trans_info set source_id=?, source_account=?, destination_id=?," +
                " destination_account=?, amount=? where id=?;";
        PreparedStatement ptmt = conn.prepareStatement(sql);


        ptmt.setInt(1, transInfo.getSource_id());
        ptmt.setString(2, transInfo.getSource_account());
        ptmt.setInt(3, transInfo.getDestination_id());
        ptmt.setString(4, transInfo.getDestination_account());
        ptmt.setDouble(5, transInfo.getAmount());
        ptmt.setInt(6, transInfo.getId());

        ptmt.execute();
    }

    public void delete(TransInfo transInfo) throws SQLException {
        Connection conn = DB.getConnection();
        String sql ="" +
                "delete from trans_info where id=?;";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, transInfo.getId());
        ptmt.execute();
    }

    public List<TransInfo> query(TransInfo transInfo) throws SQLException {
        List<TransInfo> result = new ArrayList<TransInfo>();
        Connection conn = DB.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from trans_info ");
        sb.append("where account like ?");


        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ptmt.setString(1, "%"+transInfo.getSource_account()+"%");
        ResultSet rs=ptmt.executeQuery();

        TransInfo t = null;
        while (rs.next()) {
            t = new TransInfo();
            t.setId(rs.getInt("id"));
            t.setSource_account(rs.getString("source_account"));
            t.setSource_id(rs.getInt("source_id"));
            t.setDestination_account(rs.getString("destination_account"));
            t.setDestination_id(rs.getInt("destination_id"));
            t.setAmount(rs.getDouble("amount"));
            t.setCreateDate(rs.getDate("create_at"));
            result.add(t);
        }
        return result;
}
}
