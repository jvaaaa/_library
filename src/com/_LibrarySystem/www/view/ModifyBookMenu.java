package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.BookAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ModifyBookMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public ModifyBookMenu() {
        int id;
        System.out.print("请输入你需要修改的书籍id:");
        try {
            while (true) {
                try {
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if (!BookAction.contain(id)) {
                        System.out.print("无该书籍,请重新输入:");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.print("非法输入,请重新输入:");
                }
            }
            BookAction.query(id);
            boolean close = false;
            while (!close) {
                System.out.println("你可以修改的信息有");
                System.out.println("1.ISBN");
                System.out.println("2.name");
                System.out.println("3.category");
                System.out.println("4.number");
                System.out.println("5.price");
                System.out.println("6.author");
                System.out.println("7.修改完成");
                System.out.print("你要执行的命令为(输入命令前的编号):");
                try {
                    int select = scanner.nextInt();
                    scanner.nextLine();
                    switch (select){
                        case 1:
                            System.out.print("请输入修改后的ISBN:");
                            String ISBN = scanner.nextLine();
                            if (BookAction.modify(id,"ISBN",ISBN)){
                                System.out.println("修改成功");
                            }else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 2:
                            System.out.print("请输入修改后的name:");
                            String name = scanner.nextLine();
                            if (BookAction.modify(id,"name",name)){
                                System.out.println("修改成功");
                            }else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 3:
                            System.out.print("请输入修改后的category:");
                            String category = scanner.nextLine();
                            if (BookAction.modify(id,"category",category)){
                                System.out.println("修改成功");
                            }else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 4:
                            System.out.print("请输入修改后的number(需要大于0):");
                            int number;
                            while (true) {
                                try {
                                    number = scanner.nextInt();
                                    scanner.nextLine();
                                    if (number <= 0){
                                        System.out.print("number需要大于0,请重新输入:");
                                    }else {
                                        if (BookAction.modify(id,"number",number)){
                                            System.out.println("修改成功");
                                        }else {
                                            System.out.println("修改失败");
                                        }
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    scanner.nextLine();
                                    System.out.print("非法输入,请重新输入:");
                                }
                            }
                            break;
                        case 5:
                            System.out.print("请输入修改后的price(需要大于0):");
                            double price;
                            while (true) {
                                try {
                                    price = scanner.nextDouble();
                                    scanner.nextLine();
                                    if (price <= 0){
                                        System.out.print("price需要大于0,请重新输入:");
                                    }else {
                                        if (BookAction.modify(id,"price",price)){
                                            System.out.println("修改成功");
                                        }else {
                                            System.out.println("修改失败");
                                        }
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    scanner.nextLine();
                                    System.out.print("非法输入,请重新输入:");
                                }
                            }
                            break;
                        case 6:
                            System.out.print("请输入修改后的author:");
                            String author = scanner.nextLine();
                            if (BookAction.modify(id,"author",author)){
                                System.out.println("修改成功");
                            }else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 7:close = true;break;
                        default:System.out.println("非法输入");break;
                    }
                } catch (InputMismatchException e){
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
