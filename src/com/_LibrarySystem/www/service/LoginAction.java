package com._LibrarySystem.www.service;

import com._LibrarySystem.www.bean.User;
import com._LibrarySystem.www.dao.CommonStaffDao;
import com._LibrarySystem.www.dao.CuratorDao;
import com._LibrarySystem.www.dao.UserDao;
import com._LibrarySystem.www.util.BeanUtil;
import com._LibrarySystem.www.view.CommonStaffMenu;
import com._LibrarySystem.www.view.CuratorMenu;

import java.sql.SQLException;
import java.util.List;

public class LoginAction {

    public static User Login(String username, String password) throws SQLException {
        List<User> userList = UserDao.queryAll();
        for (User user : userList){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static void Login(User user) throws SQLException,ClassNotFoundException{
        if (CommonStaffDao.contain(user)){
            new CommonStaffMenu(BeanUtil.toCommonStaff(user));
        }else if (CuratorDao.contain(user)){
            new CuratorMenu(BeanUtil.toCurator(user));
        }else {
            throw new ClassNotFoundException("未定义的类型");
        }
    }
}
