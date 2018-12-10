package com.jdbc.test;

import com.jdbc.dao.ProduceDao;
import com.jdbc.Entity.Goddess;

import java.sql.SQLException;
import java.util.List;

public class SPTest {
    public static void main(String[] args) {

        String sp_name = "";
        List<Goddess> result = null;
        Integer count = 0;
        try {
//            result = select_filter(sp_name);
//            showResult(result);
            count = select_count();
            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Integer select_count() throws SQLException {
        ProduceDao dao = new ProduceDao();
        return dao.select_count();
    }


    public static List<Goddess> select_filter(String sp_name) throws SQLException {
        ProduceDao dao = new ProduceDao();
        return dao.select_filter(sp_name);
    }

    public static void showResult(List<Goddess> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getId() +
                    ":" + result.get(i).getUser_name() +
                    ":" + result.get(i).getMobile());
        }

    }
}
