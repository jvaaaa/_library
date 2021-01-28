package com._LibrarySystem.www.view;

import com._LibrarySystem.www.bean.CommonStaff;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public CommonStaffMenu(CommonStaff commonStaff) {
        boolean close = false;

        System.out.println("欢迎你，管理员:" + commonStaff.getName());
        while (!close) {
            System.out.println("你可以执行的操作有:");
            System.out.println("1.借出书籍");
            System.out.println("2.归还书籍");
            System.out.println("3.退出");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select){
                    case 1:new BorrowBookMenu();break;
                    case 2:new RevertBookMenu();break;
                    case 3:close = true;break;
                    default:System.out.println("非法输入");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("非法输入");
            }
        }
    }
}
