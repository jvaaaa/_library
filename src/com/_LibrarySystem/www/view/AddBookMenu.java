package com._LibrarySystem.www.view;

import com._LibrarySystem.www.bean.CategoryStaff;
import com._LibrarySystem.www.service.BookAction;
import com._LibrarySystem.www.service.CategoryAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddBookMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public AddBookMenu(){
        int id,number;
        String ISBN,name,category,author;
        double price;

        System.out.println("添加图书,请输入以下信息:");
        System.out.print("id(需要大于0):");
        while (true) {
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (BookAction.contain(id)){
                    System.out.print("已经存在该书籍id,请重新输入:");
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
        System.out.print("ISBN:");
        ISBN = scanner.nextLine();
        System.out.print("name:");
        name  = scanner.nextLine();
        System.out.print("category:");
        category = scanner.nextLine();
        System.out.print("number:");
        while (true) {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                if (number <=0){
                    System.out.print("number需要大于0,请重新输入:");
                }else {
                    break;
                }
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.print("非法输入,请重新输入:");
            }
        }
        System.out.print("price:");
        while (true) {
            try {
                price = scanner.nextDouble();
                scanner.nextLine();
                if (price <=0){
                    System.out.print("price需要大于0,请重新输入:");
                }else {
                    break;
                }
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.print("非法输入,请重新输入:");
            }
        }
        System.out.print("author:");
        author = scanner.nextLine();
        try {
            if (BookAction.add(id, ISBN, name, category, number, price, author)) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        }catch (SQLException e){
            System.out.println("数据库错误:");
            e.printStackTrace();
        }
    }

    public AddBookMenu(CategoryStaff categoryStaff) {
        int id, number;
        String ISBN, name, author;
        double price;

        System.out.println("添加图书,请输入以下信息:");
        System.out.print("id(需要大于0):");
        while (true) {
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (BookAction.contain(id)) {
                    System.out.print("已经存在该书籍id,请重新输入:");
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
        System.out.print("ISBN:");
        ISBN = scanner.nextLine();
        System.out.print("name:");
        name = scanner.nextLine();
        System.out.print("number:");
        while (true) {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                if (number <= 0) {
                    System.out.print("number需要大于0,请重新输入:");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("非法输入,请重新输入:");
            }
        }
        System.out.print("price:");
        while (true) {
            try {
                price = scanner.nextDouble();
                scanner.nextLine();
                if (price <= 0) {
                    System.out.print("price需要大于0,请重新输入:");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("非法输入,请重新输入:");
            }
        }
        System.out.print("author:");
        author = scanner.nextLine();
        try {
            if (BookAction.add(id, ISBN, name, CategoryAction.query(categoryStaff.getCategoryID()).getName(), number, price, author)) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            System.out.println("数据库错误:");
            e.printStackTrace();
        }
    }
}
