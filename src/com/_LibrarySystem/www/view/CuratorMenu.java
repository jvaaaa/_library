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
            System.out.println("1.书籍管理");
            System.out.println("2.普通员工管理");
            System.out.println("3.书籍类型管理");
            System.out.println("4.书籍管理员管理");
            System.out.println("5.退出");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select){
                    case 1:
                        boolean close1 =false;
                        while (!close1) {
                            System.out.println("你可以执行的操作有:");
                            System.out.println("1.查询书籍信息");
                            System.out.println("2.增加书籍");
                            System.out.println("3.删除书籍");
                            System.out.println("4.修改书籍信息");
                            System.out.println("5.借出书籍");
                            System.out.println("6.归还书籍");
                            System.out.println("7.返回上一步");
                            System.out.print("你要执行的命令为(输入命令前的编号):");
                            try {
                                int sel = scanner.nextInt();
                                scanner.nextLine();
                                switch (sel) {
                                    case 1:
                                        new QueryBookMenu();
                                        break;
                                    case 2:
                                        new AddBookMenu();
                                        break;
                                    case 3:
                                        new DeleteBookMenu();
                                        break;
                                    case 4:
                                        new ModifyBookMenu();
                                        break;
                                    case 5:
                                        new BorrowBookMenu();
                                        break;
                                    case 6:
                                        new RevertBookMenu();
                                        break;
                                    case 7:
                                        close1 = true;
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
                        break;
                    case 2:
                        boolean close2 = false;
                        while (!close2) {
                            System.out.println("你可以执行的操作有:");
                            System.out.println("1.查询普通员工信息");
                            System.out.println("2.增加普通员工");
                            System.out.println("3.删除普通员工");
                            System.out.println("4.修改普通员工信息");
                            System.out.println("5.返回上一步");
                            System.out.print("你要执行的命令为(输入命令前的编号):");
                            try {
                                int sel = scanner.nextInt();
                                scanner.nextLine();
                                switch (sel){
                                    case 1:
                                        new QueryCommonStaffMenu();
                                        break;
                                    case 2:
                                        new AddCommonStaffMenu();
                                        break;
                                    case 3:
                                        new DeleteCommonStaffMenu();
                                        break;
                                    case 4:
                                        new ModifyCommonStaffMenu();
                                        break;
                                    case 5:
                                        close2=true;
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
                        break;
                    case 3:
                        boolean close3 = false;
                        while (!close3){
                            System.out.println("你可以执行的操作有:");
                            System.out.println("1.添加书籍类型");
                            System.out.println("2.删除书籍类型");
                            System.out.println("3.返回上一步");
                            System.out.print("你要执行的命令为(输入命令前的编号):");
                            try {
                                int sel = scanner.nextInt();
                                scanner.nextLine();
                                switch (sel){
                                    case 1:
                                        new AddCategoryMenu();
                                        break;
                                    case 2:
                                        new DeleteCategoryMenu();
                                        break;
                                    case 3:
                                        close3 = true;
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
                        break;
                    case 4:
                        boolean close4 = false;
                        while (!close4){
                            System.out.println("你可以执行的操作有:");
                            System.out.println("1.查询书目管理员信息");
                            System.out.println("2.增加书目管理员");
                            System.out.println("3.删除书目管理员");
                            System.out.println("4.修改书目管理员信息");
                            System.out.println("5.返回上一步");
                            System.out.print("你要执行的命令为(输入命令前的编号):");
                            try {
                                int sel = scanner.nextInt();
                                scanner.nextLine();
                                switch (sel){
                                    case 1:
                                        new QueryCategoryStaffMenu();
                                        break;
                                    case 2:
                                        new AddCategoryStaffMenu();
                                        break;
                                    case 5:
                                        close4 = true;
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
                        break;
                    case 5:close=true;break;
                    default:System.out.println("非法输入");break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("非法输入");
            }
        }
    }
}
