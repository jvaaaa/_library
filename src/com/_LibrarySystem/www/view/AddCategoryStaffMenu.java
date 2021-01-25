package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.CategoryAction;
import com._LibrarySystem.www.service.CategoryStaffAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddCategoryStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public AddCategoryStaffMenu(){
        int id,categoryID;
        String gender;

        System.out.println("添加书目管理员,请输入以下信息:");
        System.out.print("id(需要大于0):");
        while (true) {
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (CategoryStaffAction.contain(id)){
                    System.out.print("已经存在该书目管理员id,请重新输入:");
                }else if(id<=0){
                    System.out.print("id需要大于0,请重新输入:");
                }else{
                    break;
                }
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.print("非法输入,请重新输入:");
            } catch (SQLException e){
                System.out.println("数据库错误:");
                e.printStackTrace();
            }
        }
        System.out.print("name:");
        String name = scanner.nextLine();
        while (true) {
            System.out.print("gender:");
            gender = scanner.nextLine();
            if (gender.equals("男") || gender.equals("女")) {
                break;
            } else {
                System.out.println("性别必须为男或者女");
            }
        }
        System.out.print("contact:");
        String contact = scanner.nextLine();
        while (true) {
            try {
                System.out.print("categoryID:");
                categoryID = scanner.nextInt();
                scanner.nextLine();
                if (CategoryAction.contain(categoryID)){
                    break;
                }else {
                    System.out.println("没有该category");
                }
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("非法输入");
            }catch (SQLException e){
                System.out.println("数据库错误:");
                e.printStackTrace();
            }
        }
        System.out.print("telephone:");
        String telephone = scanner.nextLine();
        try {
            if (CategoryStaffAction.add(id,name,gender,contact,categoryID,telephone)){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        }catch (SQLException e){
            System.out.println("数据库错误:");
            e.printStackTrace();
        }
    }
}
