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
            System.out.println("1.查询书籍信息");
            System.out.println("2.增加书籍");
            System.out.println("3.删除书籍");
            System.out.println("4.修改书籍信息");
            System.out.println("5.借出书籍");
            System.out.println("6.归还书籍");
            System.out.println("7.退出");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select){
                    case 1:new QueryBookMenu();break;
                    case 2:new AddBookMenu();break;
                    case 3:new DeleteBookMenu();break;
                    case 4:new ModifyBookMenu();break;
                    case 5:new BorrowBookMenu();break;
                    case 6:new RevertBookMenu();break;
                    case 7:close = true;break;
                    default:System.out.println("非法输入");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("非法输入");
            }
        }
    }
}
