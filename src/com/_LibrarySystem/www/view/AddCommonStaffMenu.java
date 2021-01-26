package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.CommonStaffAction;
import com._LibrarySystem.www.service.UserAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddCommonStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public AddCommonStaffMenu() {
        int id;
        String gender,username;

        System.out.println("添加职工,请输入以下信息:");
        System.out.print("id(需要大于0):");
        while (true) {
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (UserAction.contain(id)) {
                    System.out.print("已经存在该id,请重新输入:");
                } else if (id <= 0) {
                    System.out.print("id需要大于0,请重新输入:");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("非法输入,请重新输入:");
            } catch (SQLException e) {
                System.out.println("数据库错误:");
                e.printStackTrace();
            }
        }
        System.out.print("username:");
        while (true) {
            try {
                username = scanner.nextLine();
                if (UserAction.contain(username)) {
                    System.out.print("已经存在该用户名,请重新输入:");
                } else {
                    break;
                }
            }catch (SQLException e){
                System.out.println("数据库错误");
                e.printStackTrace();
            }
        }
        System.out.print("password:");
        String password = scanner.nextLine();
        System.out.print("name:");
        String name = scanner.nextLine();
        System.out.print("gender:");
        while (true) {
            gender = scanner.nextLine();
            if (gender.equals("男") || gender.equals("女")) {
                break;
            } else {
                System.out.print("性别必须为男或者女:请重新输入");
            }
        }
        System.out.print("telephone:");
        String telephone = scanner.nextLine();
        try {
            if (CommonStaffAction.add(id, name, gender, telephone) && UserAction.add(id,username,password)) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        }catch (SQLException e){
            System.out.println("数据库错误");
            e.printStackTrace();
        }
    }
}
