package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.LibraryAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteLibraryMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public DeleteLibraryMenu(){
        System.out.print("请输入需要删除的图书馆id:");
        try {
            while (true){
                try {
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (LibraryAction.contain(id)){
                        if (LibraryAction.delete(id)){
                            System.out.println("删除成功");
                        }else {
                            System.out.println("删除失败");
                        }
                    }else {
                        System.out.println("没有该图书馆");
                    }
                    break;
                }catch (InputMismatchException e){
                    scanner.nextLine();
                    System.out.println("非法输入,请重新输入:");
                }
            }
        }catch (SQLException e){
            System.out.println("数据库错误");
            e.printStackTrace();
        }
    }
}
