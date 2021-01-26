package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.CategoryStaffAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ModifyCategoryStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public ModifyCategoryStaffMenu() {
        int id;

        try {
            System.out.print("请输入你需要修改的书目管理员id:");
            while (true) {
                try {
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if (CategoryStaffAction.contain(id)){
                        break;
                    }else {
                        System.out.print("无该书目管理员,请重新输入:");
                    }
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.print("非法输入,请重新输入:");
                }
            }
            CategoryStaffAction.query(id);
            boolean close = false;
            while (!close){
                System.out.println("你可以修改的信息有");
                System.out.println("1.name");
                System.out.println("2.gender");
                System.out.println("3.contact");
                System.out.println("4.telephone");
                System.out.println("5.修改完成");
                System.out.print("你要执行的命令为(输入命令前的编号):");
                try {
                    int select = scanner.nextInt();
                    scanner.nextLine();
                    switch (select) {
                        case 1:
                            System.out.print("请输入修改后的name:");
                            String name = scanner.nextLine();
                            if (CategoryStaffAction.modify(id,"name",name)){
                                System.out.println("修改成功");
                            }else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 2:
                            String gender;
                            System.out.print("请输入修改后的gender:");
                            while (true) {
                                gender = scanner.nextLine();
                                if (gender.equals("男") || gender.equals("女")){
                                    break;
                                }else {
                                    System.out.print("性别必须为男或者女,请重新输入:");
                                }
                            }
                            if (CategoryStaffAction.modify(id,"gender",gender)){
                                System.out.println("修改成功");
                            }else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 3:
                            System.out.print("请输入修改后的contact:");
                            String contact = scanner.nextLine();
                            if (CategoryStaffAction.modify(id,"contact",contact)){
                                System.out.println("修改成功");
                            }else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 4:
                            System.out.print("请输入修改后的telephone:");
                            String telephone = scanner.nextLine();
                            if (CategoryStaffAction.modify(id,"telephone",telephone)){
                                System.out.println("修改成功");
                            }else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 5:close = true;break;
                        default:System.out.println("非法输入");break;
                    }
                }catch (InputMismatchException e){
                    scanner.nextLine();
                    System.out.println("非法输入");
                }
            }
        }catch (SQLException e){
            System.out.println("数据库错误");
            e.printStackTrace();
        }
    }
}
