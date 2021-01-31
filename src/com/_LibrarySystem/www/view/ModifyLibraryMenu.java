package com._LibrarySystem.www.view;

import com._LibrarySystem.www.service.CuratorAction;
import com._LibrarySystem.www.service.LibraryAction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ModifyLibraryMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public ModifyLibraryMenu(){
        int id;

        System.out.print("请输入你需要修改的图书馆id:");
        try {
            while (true){
                try {
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if (LibraryAction.contain(id)){
                        break;
                    }else {
                        System.out.print("无该图书馆,请重新输入:");
                    }
                }catch (InputMismatchException e){
                    scanner.nextLine();
                    System.out.print("非法输入,请重新输入:");
                }
            }
            LibraryAction.query(id);
            boolean close = false;
            while (!close){
                System.out.println("你可以修改的信息有");
                System.out.println("1.name");
                System.out.println("2.address");
                System.out.println("3.CuratorID");
                System.out.println("4.修改完成");
                System.out.print("你要执行的命令为(输入命令前的编号):");
                try {
                    int select = scanner.nextInt();
                    scanner.nextLine();
                    switch (select){
                        case 1:
                            System.out.print("请输入修改后的name:");
                            String name = scanner.nextLine();
                            if (LibraryAction.modify(id,"name",name)){
                                System.out.println("修改成功");
                            }else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 2:
                            System.out.print("请输入修改后的address:");
                            String address = scanner.nextLine();
                            if (LibraryAction.modify(id,"address",address)){
                                System.out.println("修改成功");
                            }else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 3:
                            System.out.print("请输入修改后的CuratorID:");
                            while (true){
                                try {
                                    int CuratorID = scanner.nextInt();
                                    scanner.nextLine();
                                    if (CuratorAction.contain(CuratorID)){
                                        if (LibraryAction.modify(id,"CuratorID",CuratorID)){
                                            System.out.println("修改成功");
                                        }else {
                                            System.out.println("修改失败");
                                        }
                                        break;
                                    }else {
                                        System.out.print("无该馆长,请重新输入:");
                                    }
                                }catch (InputMismatchException e){
                                    scanner.nextLine();
                                    System.out.print("非法输入,请重新输入:");
                                }
                            }
                            break;
                        case 4:close=true;break;
                        default:System.out.println("非法输入");break;
                    }
                }catch (InputMismatchException e){
                    scanner.nextLine();
                    System.out.println("非法输入");
                }
            }
        }catch (SQLException e){
            System.out.println("数据库错误:");
            e.printStackTrace();
        }
    }
}
