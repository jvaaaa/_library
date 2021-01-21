package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.BookAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RevertBookMenu {
    private static final Scanner scanner = new Scanner(System.in);
    int id;
    public RevertBookMenu(){
        System.out.print("请输入需要借出的归还id:");
        while (true) {
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("非法输入,请重新输入:");
            }
        }
        try {
            if (BookAction.revert(id)){
                System.out.println("归还成功");
            }else {
                System.out.println("归还失败");
            }
        }catch (SQLException e){
            System.out.println("数据库错误:");
            e.printStackTrace();
        }
    }
}
