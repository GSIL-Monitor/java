package com.jdbc.dao;

import com.jdbc.db.DB;
import com.jdbc.Entity.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduceDao {

    public static Integer select_count() throws SQLException {
        Integer count=0;
        Connection conn = DB.getConnection();
        CallableStatement cs = conn.prepareCall("call new_procedure_count(?)");
        cs.registerOutParameter(1, Types.INTEGER);
        cs.execute();

        count=cs.getInt(1);
        return count;
    }

    public static List<Goddess> select_filter(String sp_name) throws SQLException {
        List<Goddess> result = new ArrayList<Goddess>();

        Connection conn = DB.getConnection();
        CallableStatement cs = conn.prepareCall("call new_procedure_filter(?)");
        cs.setString(1, sp_name);
        cs.execute();

        ResultSet rs = cs.getResultSet();
        Goddess g = null;
        while (rs.next()) {
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setMobile(rs.getString("mobile"));
            result.add(g);

        }
        return result;
    }




    public static void select_nofilter() throws SQLException {
        Connection conn = DB.getConnection();
        CallableStatement cs = conn.prepareCall("call new_procedure_nofilter");
        cs.execute();
        ResultSet rs = cs.getResultSet();


        while (rs.next()) {
            System.out.println(rs.getString("user_name") + rs.getString("email"));
        }
    }
}
