package exp1.view;

import exp1.bean.CommonStaff;
import exp1.bean.User;
import exp1.dao.CommonStaffDao;
import exp1.dao.UserDao;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DispatchCommonStaffMenu {
    private static final Scanner scanner = new Scanner(System.in);

    private void commonStaffDelete(){
        CommonStaff commonStaff = new CommonStaff();
        User user = new User();
        try {
            System.out.print("请输入你要辞退的员工ID(输入0返回上一步):");
            int id = scanner.nextInt();
            if (id < 0){
                throw new InputMismatchException();
            }
            if (id == 0){
                throw new RuntimeException();
            }
            scanner.nextLine();
            user.setId(id);
            commonStaff.setId(id);
            if (CommonStaffDao.delete(commonStaff) && UserDao.delete(user)){
                System.out.println("辞退成功");
            }else{
                System.out.println("辞退失败");
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("非法输入,已返回上一步");
        }catch (RuntimeException e){
            scanner.nextLine();
            System.out.println("已返回上一步");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void commonStaffAdd(){
        try {
            CommonStaff commonStaff = new CommonStaff();
            User user = new User();
            System.out.println("请输入以下信息:");
            System.out.print("id(id需要大于0):");
            int id = scanner.nextInt();
            if (id <= 0){
                throw new InputMismatchException();
            }
            scanner.nextLine();
            commonStaff.setId(id);
            user.setId(id);
            System.out.print("username:");
            String username = scanner.nextLine();
            user.setUsername(username);
            System.out.print("password:");
            String password = scanner.nextLine();
            user.setPassword(password);
            System.out.print("name:");
            String name = scanner.nextLine();
            commonStaff.setName(name);
            System.out.print("gender:");
            String gender = scanner.nextLine();
            commonStaff.setGender(gender);
            System.out.print("telephone:");
            String telephone = scanner.nextLine();
            commonStaff.setTelephone(telephone);
            if (UserDao.add(user) && CommonStaffDao.add(commonStaff)){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("非法输入，已返回上一步");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void staffDispatch() {
        User user = new User();
        try {
            System.out.println("id为普通员工则调度为书目管理员，id为数目管理员则调度为普通员工");
            System.out.print("请输入需要调度的员工id(输入0返回上一步):");
            int id = scanner.nextInt();
            if (id == 0) {
                throw new RuntimeException();
            }
            if (id < 0) {
                throw new InputMismatchException();
            }
            scanner.nextLine();
            user.setId(id);
            if (CommonStaffDao.contain(user)){
                System.out.println("请输入以下信息:");
                System.out.print("联系方式");
                String contact = scanner.nextLine();
                System.out.print("书籍类型id");
                int categoryID = scanner.nextInt();
                if (categoryID <= 0){
                    throw new InputMismatchException();
                }
                scanner.nextLine();
                CommonStaff commonStaff = new CommonStaff();
                commonStaff.setId(user.getId());
                if (CommonStaffDao.dispatch(commonStaff,contact,categoryID)){
                    System.out.println("调度成功");
                }else {
                    System.out.println("调度失败");
                }
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("非法输入,已返回上一步");
        }catch (RuntimeException e){
            scanner.nextLine();
            System.out.println("已退出");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public DispatchCommonStaffMenu(){
        boolean close = false;
        while (!close) {
            System.out.println("你可以执行的操作有;");
            System.out.println("1.增加员工");
            System.out.println("2.辞退员工");
            System.out.println("3.调度员工");
            System.out.println("4.返回上一级");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select){
                    case 1:
                        commonStaffAdd();
                        break;
                    case 2:
                        commonStaffDelete();
                        break;
                    case 3:
                        staffDispatch();
                        break;
                    case 4:
                        //返回上一级
                        close = true;
                        break;
                    default:
                        System.out.println("非法输入");
                }
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("非法输入");
            }
        }
    }
}
