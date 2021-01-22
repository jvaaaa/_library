package exp1.view;

import exp1.service.Login;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public CommonStaffMenu() {
        boolean close = false;
        while (!close) {
            System.out.println("你可以执行的操作有:");
            System.out.println("1.查询书籍信息");
            System.out.println("2.管理书籍信息");
            System.out.println("3.借出书籍");
            System.out.println("4.归还书籍");
            System.out.println("5.重新登录");
            System.out.println("6.退出");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select) {
                    case 1:
                        //查询
                        new QueryBookMenu();
                        break;
                    case 2:
                        //管理
                        new ManageBookMenu();
                        break;
                    case 3:
                        //借出
                        new BorrowBookMenu();
                        break;
                    case 4:
                        new RevertBookMenu();
                        break;
                        //归还
                    case 5:
                        new Login();
                        close = true;
                        break;
                    case 6:
                        close = true;
                        break;
                    default:
                        System.out.println("输入非法");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("输入非法");
            }
        }
    }
}
