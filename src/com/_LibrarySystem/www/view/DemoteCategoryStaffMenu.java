package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.CategoryStaffAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoteCategoryStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public DemoteCategoryStaffMenu(){
        int id;

        System.out.print("请输入需要降职的书目管理员id:");
        try {
            while (true){
                try {
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if (CategoryStaffAction.contain(id)){
                        break;
                    }else {
                        System.out.print("无该员工,请重新输入:");
                    }
                }catch (InputMismatchException e){
                    scanner.nextLine();
                    System.out.print("非法输入,请重新输入:");
                }
            }
            if (CategoryStaffAction.demote(id)){
                System.out.println("降职成功");
            }else {
                System.out.println("降职失败");
            }
        }catch (SQLException e){
            System.out.println("数据库错误:");
            e.printStackTrace();
        }
    }
}
