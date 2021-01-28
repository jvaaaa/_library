package com._LibrarySystem.www.view;

import com._LibrarySystem.www.bean.CategoryStaff;
import com._LibrarySystem.www.service.BookAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QueryBookMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public QueryBookMenu(){
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
    }

    public QueryBookMenu(CategoryStaff categoryStaff){
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
    }
}
