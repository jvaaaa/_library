package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.CommonStaffAction;
import com._LibrarySystem.www.service.UserAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ModifyCommonStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public ModifyCommonStaffMenu() {
        int id;
        String username,gender;
        System.out.print("请输入你需要修改的员工id:");
            try {
                while (true) {
                    try {
                        id = scanner.nextInt();
                        scanner.nextLine();
                        if (!CommonStaffAction.contain(id)) {
                            System.out.print("无该员工,请重新输入:");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine();
                        System.out.print("非法输入,请重新输入:");
                    }
                }
                CommonStaffAction.query(id);
                boolean close = false;
                while (!close) {
                    System.out.println("你可以修改的信息有");
                    System.out.println("1.name");
                    System.out.println("2.gender");
                    System.out.println("3.telephone");
                    System.out.println("4.修改完成");
                    System.out.print("你要执行的命令为(输入命令前的编号):");
                    try {
                        int select = scanner.nextInt();
                        scanner.nextLine();
                        switch (select){
                            case 1:
                                System.out.print("请输入修改后的name:");
                                String name = scanner.nextLine();
                                if (CommonStaffAction.modify(id,"name",name)){
                                    System.out.println("修改成功");
                                }else {
                                    System.out.println("修改失败");
                                }
                                break;
                            case 2:
                                System.out.print("请输入修改后的gender:");
                                while (true) {
                                    gender = scanner.nextLine();
                                    if (gender.equals("男") || gender.equals("女")){
                                        break;
                                    }else {
                                        System.out.print("性别必须为男或者女,请重新输入:");
                                    }
                                }
                                if (CommonStaffAction.modify(id,"gender",gender)){
                                    System.out.println("修改成功");
                                }else {
                                    System.out.println("修改失败");
                                }
                                break;
                            case 3:
                                System.out.print("请输入修改后的gender:");
                                String telephone = scanner.nextLine();
                                if (CommonStaffAction.modify(id,"telephone",telephone)){
                                    System.out.println("修改成功");
                                }else {
                                    System.out.println("修改失败");
                                }
                                break;
                            case 4:
                                close=true;
                                break;
                            default:System.out.println("非法输入");break;
                        }
                    }catch (InputMismatchException e){
                        scanner.nextLine();
                        System.out.println("非法输入");
                    }
                }
        }catch (SQLException e){
            System.out.println("数据库错误:");
            e.printStackTrace();
        }
    }
}
