package com._LibrarySystem.www.view;

import com._LibrarySystem.www.bean.CategoryStaff;
import com._LibrarySystem.www.service.BookAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QueryBookMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public QueryBookMenu(){
        System.out.println("你可以执行的操作有");
        System.out.println("1.id精确查询");
        System.out.println("2.模糊查询");
        System.out.print("你要执行的命令为(输入命令前的编号):");
        try {
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select){
                case 1:
                    System.out.print("请输入需要查询的id(输入0查询全部):");
                    while (true) {
                        try {
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            BookAction.query(id);
                            break;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.print("非法输入,请重新输入:");
                        } catch (SQLException e){
                            System.out.println("数据库错误:");
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    try {
                        System.out.print("请输入需要查询的内容:");
                        String statement = scanner.nextLine();
                        BookAction.fuzzyQuery(statement);
                    } catch (SQLException e){
                        System.out.println("数据库错误:");
                        e.printStackTrace();
                    }
                    break;
                default:System.out.println("非法输入");
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("非法输入");
        }
    }

    public QueryBookMenu(CategoryStaff categoryStaff){
        System.out.println("你可以执行的操作有");
        System.out.println("1.id精确查询");
        System.out.println("2.模糊查询");
        System.out.print("你要执行的命令为(输入命令前的编号):");
        try {
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select){
                case 1:
                    System.out.print("请输入需要查询的id(输入0查询全部):");
                    while (true) {
                        try {
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            BookAction.query(categoryStaff,id);
                            break;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.print("非法输入,请重新输入:");
                        } catch (SQLException e){
                            System.out.println("数据库错误:");
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    try {
                        System.out.print("请输入需要查询的内容:");
                        String statement = scanner.nextLine();
                        BookAction.fuzzyQuery(categoryStaff,statement);
                    } catch (SQLException e){
                        System.out.println("数据库错误:");
                        e.printStackTrace();
                    }
                    break;
                default:System.out.println("非法输入");
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("非法输入");
        }
    }
}
