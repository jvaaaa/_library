package exp1.view;

import exp1.bean.CommonStaff;
import exp1.bean.User;
import exp1.dao.CommonStaffDao;
import exp1.dao.UserDao;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageCommonStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    private static void queryShow(CommonStaff commonStaff){
        System.out.println("该员工信息如下:");
        System.out.printf("id:%d\tname:%s\tgender:%s\ttelephone:%s\n",commonStaff.getId(),commonStaff.getName(),commonStaff.getGender(),commonStaff.getTelephone());
    }

    private static void queryCommonStaffMenu(){
        System.out.print("请输入你要查询的员工ID(输入0返回上一步):");
        try {
            int id = scanner.nextInt();
            if (id < 0){
                throw new InputMismatchException();
            }
            else if (id == 0){
                throw new RuntimeException();
            }else {
                scanner.nextLine();
                CommonStaff commonStaff = CommonStaffDao.query(id);
                if (commonStaff.getId() == 0){
                    System.out.println("未查到该员工");
                }else {
                    queryShow(commonStaff);
                }
            }
        } catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("非法输入，已返回上一步");
        } catch (RuntimeException e){
            scanner.nextLine();
            System.out.println("已返回上一步");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void modifyCommonStaffMenu(){
        try{
            CommonStaff commonStaff = new CommonStaff();
            User user = new User();
            System.out.print("请输入你要修改的员工ID(输入0返回上一步):");
            int id = scanner.nextInt();
            scanner.nextLine();
            commonStaff.setId(id);
            user.setId(id);
            if (id == 0){
                throw new RuntimeException();
            }else {
                System.out.println("可修改的内容为:");
                System.out.println("1.id");
                System.out.println("2.username");
                System.out.println("3.password");
                System.out.println("4.name");
                System.out.println("5.gender");
                System.out.println("6.telephone");
                System.out.print("请输入你要修改的内容(输入命令前的编号):");
                int select = scanner.nextInt();
                scanner.nextLine();
                System.out.print("修改为:");
                String modify = scanner.nextLine();
                boolean success = false;
                switch (select){
                    case 1:
                        success = CommonStaffDao.contain(user) && UserDao.modify(user,"id",modify) && CommonStaffDao.modify(commonStaff,"id",modify);
                        break;
                    case 2:
                        success = CommonStaffDao.contain(user) && UserDao.modify(user,"username",modify);
                        break;
                    case 3:
                        success = CommonStaffDao.contain(user) && UserDao.modify(user,"password",modify);
                        break;
                    case 4:
                        success = CommonStaffDao.modify(commonStaff,"name",modify);
                        break;
                    case 5:
                        success = CommonStaffDao.modify(commonStaff,"gender",modify);
                        break;
                    case 6:
                        success = CommonStaffDao.modify(commonStaff,"telephone",modify);
                        break;
                    default:
                        System.out.println("非法输入，已返回上一步");
                }
                if (success){
                    System.out.println("修改成功");
                }else {
                    System.out.println("修改失败");
                }
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("非法输入，已返回上一步");
        }catch (RuntimeException e){
            System.out.println("已返回上一步");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ManageCommonStaffMenu(){
        boolean close = false;
        while (!close) {
            System.out.println("你可以执行的操作有:");
            System.out.println("1.查询员工信息");
            System.out.println("2.修改员工信息");
            System.out.println("3.退出");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select) {
                    case 1:
                        queryCommonStaffMenu();
                        break;
                    case 2:
                        modifyCommonStaffMenu();
                        break;
                    case 3:
                        close = true;
                        break;
                    default:
                        System.out.println("非法输入");
                }
            }catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("非法输入");
            }
        }
    }
}
