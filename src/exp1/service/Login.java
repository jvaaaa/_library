package exp1.service;


import exp1.bean.User;
import exp1.dao.UserDao;
import exp1.view.Menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


/**
 * 登录程序
 */
public class Login {
    /**
     * 通过queryAll获取所有用户的信息
     * 通过List储存信息
     * 遍历List验证账号密码是正确
     * 如果正确进入主菜单
     * 遍历完成如果没有对应的账号密码则返回:账号或密码错误
     */
    private static final Scanner scanner = new Scanner(System.in);

    public Login() {
        boolean close = false;
        while (!close) {
            System.out.println("登录程序:");
            System.out.print("请输入用户名:");
            String username = scanner.nextLine();
            System.out.print("请输入密码:");
            String password = scanner.nextLine();
            try {
                List<User> userList = UserDao.queryAll();
                for (User user : userList) {
                    //验证用户名和密码
                    if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                        System.out.println("登录成功");
                        new Menu(user);
                        close = true;
                        break;
                        //用户名或密码为空
                    } else if (username.equals("") || password.equals("")) {
                        System.out.println("用户名和密码不能为空");
                        break;
                    } else if (user == userList.get(userList.size() - 1)) {
                        //走到list的尽头
                        System.out.println("用户名或密码错误");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
