package com.jdbc.dao;

import com.jdbc.db.DB;
import com.jdbc.Entity.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoddessDao {
    public void addGoddess(Goddess g) throws SQLException {
        Connection conn = DB.getConnection();
        String sql ="" +
                "insert into goddess" +
                "(user_name,sex,age,birthday,email,mobile," +
                "create_user,create_date,update_user,update_date,isdel)" +
                "values(" +
                "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, g.getUser_name());
        ptmt.setInt(2, g.getSex());
        ptmt.setInt(3, g.getAge());
        ptmt.setDate(4, new Date(g.getBirthday().getTime()));
        ptmt.setString(5, g.getEmail());
        ptmt.setString(6, g.getMobile());
        ptmt.setString(7, g.getCreate_user());
        ptmt.setString(8, g.getUpdate_user());
        ptmt.setInt(9, g.getIsdel());

        ptmt.execute();


    }

    public void deleteGoddess(Integer id) throws SQLException {
        Connection conn = DB.getConnection();
        String sql = "delete from goddess where id=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, id);
        ptmt.execute();

    }

    public void updateGoddess(Goddess g) throws SQLException {
        Connection conn = DB.getConnection();
        String sql = " update goddess " +
                " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
                " update_user=?,update_date=current_date(),isdel=? " +
                " where id=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, g.getUser_name());
        ptmt.setInt(2, g.getSex());
        ptmt.setInt(3, g.getAge());
        ptmt.setDate(4, new Date(g.getBirthday().getTime()));
        ptmt.setString(5, g.getEmail());
        ptmt.setString(6, g.getMobile());
        ptmt.setString(7, g.getUpdate_user());
        ptmt.setInt(8, g.getIsdel());
        ptmt.setInt(9, g.getId());
        ptmt.execute();
    }

    public List<Goddess> query() throws SQLException {
        List<Goddess> result = new ArrayList<Goddess>();
        Connection conn = DB.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append("select id,user_name,age from goddess");

        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ResultSet rs = ptmt.executeQuery();

        Goddess g = null;
        while (rs.next()) {
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            result.add(g);
        }
        return result;
    }


    public List<Goddess> query(String name, String mobile, String email) throws SQLException {
        List<Goddess> result = new ArrayList<Goddess>();
        Connection conn = DB.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append("select * from goddess where"+
                "user_name like ? and mobile like ? and email like ?");


        PreparedStatement ptmt = conn.prepareStatement(sb.toString());

        ptmt.setString(1, "%"+name+"%");
        ptmt.setString(1, "%"+mobile+"%");
        ptmt.setString(1, "%"+email+"%");

        ResultSet rs = ptmt.executeQuery();

        Goddess g=null;
        while(rs.next()){
            g=new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));
            result.add(g);
        }
        return result;
    }

    public List<Goddess> query(List<Map<String, Object>> params) throws SQLException {
        List<Goddess> result = new ArrayList<Goddess>();
        Connection conn = DB.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append("select * from goddess where 1=1");
    ///



        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ResultSet rs = ptmt.executeQuery();

        Goddess g = null;
        while (rs.next()) {
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));
            result.add(g);
        }
        return result;
    }

    public Goddess get(Integer id) throws SQLException{
        Goddess g=null;
        Connection conn= DB.getConnection();
        String sql="" +
                " select * from goddess " +
                " where id=? ";
        PreparedStatement ptmt=conn.prepareStatement(sql);

        ptmt.setInt(1, id);
        ResultSet rs=ptmt.executeQuery();
        while(rs.next()){
            g=new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));
        }
        return g;
    }

}
