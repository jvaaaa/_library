package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.LibraryAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QueryLibraryMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public QueryLibraryMenu(){
        System.out.print("请输入需要查询的id(输入0查询全部):");
        while (true) {
            try {
                int id = scanner.nextInt();
                scanner.nextLine();
                LibraryAction.query(id);
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
