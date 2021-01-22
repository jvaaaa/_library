package exp1.view;

import exp1.service.Login;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CuratorMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public CuratorMenu() {
        boolean close = false;
        while (!close) {
            System.out.println("你可以执行的操作有:");
            System.out.println("1.查询书籍信息");
            System.out.println("2.管理书籍信息");
            System.out.println("3.借出书籍");
            System.out.println("4.归还书籍");
            System.out.println("5.调度员工");
            System.out.println("6.管理员工信息");
            System.out.println("7.管理书籍类型");
            System.out.println("8.重新登录");
            System.out.println("9.退出");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select) {
                    case 1:
                        //查询图书
                        new QueryBookMenu();
                        break;
                    case 2:
                        //管理图书
                        new ManageBookMenu();
                        break;
                    case 3:
                        //借出图书
                        new BorrowBookMenu();
                        break;
                    case 4:
                        //归还图书
                        new RevertBookMenu();
                        break;
                    case 5:
                        //调度职工
                        new DispatchCommonStaffMenu();
                        break;
                    case 6:
                        //管理职工
                        new ManageCommonStaffMenu();
                        break;
                    case 7:
                        //书籍类型管理
                        new ManageCategoryMenu();
                        break;
                    case 8:
                        //重新登录
                        new Login();
                        close = true;
                        break;
                    case 9:
                        //退出
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
