package com.jdbc.view;


import com.jdbc.action.GoddessAction;
import com.jdbc.Entity.Goddess;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class View {
    private static final String CONTEXT = "欢迎来到女神禁区：\n" +
            "下面是女神禁区的功能列表：\n" +
            "[MAIN/M]:主菜单\n" +
            "[QUERY/Q]:查看全部女神的信息\n" +
            "[GET/G]:查看某位女神的详细信息\n" +
            "[ADD/A]:添加女神信息\n" +
            "[UPDATE/U]:更新女神信息\n" +
            "[DELETE/D]:删除女神信息\n" +
            "[SEARCH/S]:查询女神信息(根据姓名、手机号来查询)\n" +
            "[EXIT/E]:退出女神禁区\n" +
            "[BREAK/B]:退出当前功能，返回主菜单";

    private static final String OPERATION_MAIN = "MAIN";
    private static final String OPERATION_QUERY = "QUERY";
    private static final String OPERATION_GET = "GET";
    private static final String OPERATION_ADD = "ADD";
    private static final String OPERATION_UPDATE = "UPDATE";
    private static final String OPERATION_DELETE = "DELETE";
    private static final String OPERATION_SEARCH = "SEARCH";
    private static final String OPERATION_EXIT = "EXIT";
    private static final String OPERATION_BREAK = "BREAK";


    public static void main(String[] args) throws SQLException {
        GoddessAction act = new GoddessAction();


        System.out.println(CONTEXT);
        Scanner scan = new Scanner(System.in);
        String OPERATION = "";
        String[] str = {"m", "q", "g", "a", "u", "d", "s", "e", "b"};
        List<String> option = new ArrayList<String>();
        for (int i = 0; i < str.length; i++) {
            option.add(str[i]);
        }

        while (true){
        System.out.println("请输入操作：");
        OPERATION = scan.next();

        if (!option.contains(OPERATION)) {
            System.out.println("输入不合法，请重新输入: ");
            OPERATION = scan.next();
        }

        if (OPERATION.toLowerCase().equals("m")) {
            System.out.println(CONTEXT);
        } else if (OPERATION.toLowerCase().equals("e")) {
            System.out.println("您已成功退出");
            System.exit(0);
        } else if (OPERATION.toLowerCase().equals("q")) {
            for (Goddess g : act.query()) {
                System.out.println(g.getUser_name());
            }
        } else if (OPERATION.toLowerCase().equals("g")) {
            System.out.println("请输入要查询的女神ID： ");
            int id = scan.nextInt();
            System.out.println(act.get(id).getUser_name());
        } else if (OPERATION.toLowerCase().equals("a")) {
            Goddess goddess = new Goddess();
            String pr = OPERATION.toLowerCase();
            int step = 1;
            while (step<7){
                if (step == 1) {
                    System.out.println("请输入要添加的女神姓名： ");
                    goddess.setUser_name(scan.next());
                } else if (step == 2) {
                    System.out.println("请输入要添加的女神年龄： ");
                    try {
                        scan = new Scanner(System.in);
                        goddess.setAge(scan.nextInt());
                    }catch (InputMismatchException e){
                        e.printStackTrace();
                        System.out.println("您输入的格式有误，请重新输入");
                        step=2-1;
                    }

                } else if (step == 3) {
                    System.out.println("请输入要添加的女神生日： ");
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday = null;
                    try {
                        scan = new Scanner(System.in);
                        birthday = sf.parse(scan.next());
                        goddess.setBirthday(birthday);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("您输入的格式有误，请重新输入");
                        step=3-1;
                    }
                } else if (step == 4) {
                    System.out.println("请输入要添加的女神email： ");
                    goddess.setEmail(scan.next());
                } else if (step == 5) {
                    System.out.println("请输入要添加的女神电话： ");
                    goddess.setMobile(scan.next());
                } else if (step == 6) {
                    try {
                        act.add(goddess);
                        System.out.println("成功添加女神： " + goddess.getUser_name());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("添加女神失败");
                    }
                }
                step++;
            }


        }
        }


    }
}
