package com._LibrarySystem.www.service;

import com._LibrarySystem.www.bean.User;
import com._LibrarySystem.www.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

public class UserAction {
    public static boolean add(int id,String username,String password) throws SQLException{
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        return UserDao.add(user);
    }

    public static boolean contain(int id) throws SQLException {
        List<User> userList = UserDao.queryAll();
        for (User user : userList){
            if (user.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static boolean contain(String username)throws SQLException {
        List<User> userList = UserDao.queryAll();
        for (User user : userList){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
