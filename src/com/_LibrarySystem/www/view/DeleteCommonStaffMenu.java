package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.CommonStaffAction;
import com._LibrarySystem.www.service.UserAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteCommonStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public DeleteCommonStaffMenu(){
        System.out.print("请输入需要删除的员工id:");
        try {
            while (true){
                try {
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (CommonStaffAction.contain(id)) {
                        if (CommonStaffAction.delete(id) && UserAction.delete(id)) {
                            System.out.println("删除成功");
                        } else {
                            System.out.println("删除失败");
                        }
                    }else {
                        System.out.println("没有该员工");
                    }
                    break;
                }catch (InputMismatchException e){
                    scanner.nextLine();
                    System.out.print("非法输入,请重新输入:");
                }
            }
        }catch (SQLException e){
            System.out.println("数据库错误");
            e.printStackTrace();
        }
    }
}
