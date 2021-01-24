package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.CategoryAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddCategoryMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public AddCategoryMenu(){
        int id;

        System.out.println("添加书籍类型,请输入以下信息:");
        System.out.print("id(需要大于0):");
        while (true) {
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (CategoryAction.contain(id)){
                    System.out.print("已经存在该书籍类型id,请重新输入:");
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
        try {
            if (CategoryAction.add(id, name)) {
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
