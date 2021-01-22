package com._LibrarySystem.www.view;

import com._LibrarySystem.www.bean.Curator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CuratorMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public CuratorMenu(Curator curator){
        boolean close = false;
        System.out.println("欢迎你，馆长:" + curator.getName());
        while (!close) {
            System.out.println("你可以执行的操作有:");
            System.out.println("1.查询书籍信息");
            System.out.println("2.增加书籍");
            System.out.println("3.删除书籍");
            System.out.println("4.修改书籍信息");
            System.out.println("5.借出书籍");
            System.out.println("6.归还书籍");
            System.out.println("7.查询职工信息");
            System.out.println("8.增加职工");
            System.out.println("9.删除职工");
            System.out.println("11.退出");
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
                    case 7:new QueryCommonStaffMenu();break;
                    case 8:new AddCommonStaffMenu();break;
                    case 9:new DeleteCommonStaffMenu();break;
                    case 11:close = true;break;
                    default:System.out.println("非法输入");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("非法输入");
            }
        }
    }
}
