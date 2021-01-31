package com._LibrarySystem.www.view;

import com._LibrarySystem.www.bean.Administrator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdministratorMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public AdministratorMenu(Administrator administrator) {
        boolean close = false;
        System.out.println("欢迎你，总管理员:"+administrator.getName());
        while (!close){
            System.out.println("你可以执行的操作有:");
            System.out.println("1.查询图书馆");
            System.out.println("2.添加图书馆");
            System.out.println("3.删除图书馆");
            System.out.println("4.修改图书馆信息");
            System.out.println("5.退出");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select){
                    case 1:
                        new QueryLibraryMenu();
                        break;
                    case 2:
                        new AddLibraryMenu();
                        break;
                    case 3:
                    case 4:
                    case 5:
                        close = true;
                        break;
                    default:
                        System.out.println("非法输入");
                        break;
                }
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("非法输入");
            }
        }
    }
}
