package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.CategoryAction;
import com._LibrarySystem.www.service.CommonStaffAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PromoteCommonStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public PromoteCommonStaffMenu(){
        int id,categoryID;

        System.out.print("请输入需要升职的员工id:");
        try {
            while (true) {
                try {
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if (CommonStaffAction.contain(id)){
                        break;
                    }else {
                        System.out.print("无该员工,请重新输入:");
                    }
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.print("非法输入,请重新输入:");
                }
            }
            System.out.println("升职需要补充以下信息:");
            System.out.print("contact:");
            String contact = scanner.nextLine();
            System.out.print("categoryID:");
            while (true) {
                try {
                    categoryID = scanner.nextInt();
                    scanner.nextLine();
                    if (CategoryAction.contain(categoryID)){
                        break;
                    }else {
                        System.out.print("没有该category,请重新输入:");
                    }
                }catch (InputMismatchException e){
                    scanner.nextLine();
                    System.out.print("非法输入,请重新输入:");
                }
            }
            if (CommonStaffAction.promote(id,contact,categoryID)) {
                System.out.println("升职成功");
            } else {
                System.out.println("升职失败");
            }
        }catch (SQLException e){
            System.out.println("数据库错误:");
            e.printStackTrace();
        }
    }
}
