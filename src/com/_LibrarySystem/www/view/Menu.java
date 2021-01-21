package com._LibrarySystem.www.view;

import com._LibrarySystem.www.bean.User;
import com._LibrarySystem.www.service.LoginAction;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public Menu(){
        boolean close = false;
        User user;
        System.out.println("---欢迎来到图书馆管理系统---");
        System.out.println("请登录:");
        while (!close) {
            try {
                System.out.print("请输入用户名:");
                String username = scanner.nextLine();
                System.out.print("请输入密码:");
                String password = scanner.nextLine();
                if (username.equals("") || password.equals("")) {
                    System.out.println("用户名和密码不能为空，请重新输入");
                } else if ((user = LoginAction.Login(username,password))==null){
                    System.out.println("用户名或密码错误，请重新输入");
                } else {
                    LoginAction.Login(user);close=true;
                }
            }catch (SQLException e){
                System.out.println("数据库错误");
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
