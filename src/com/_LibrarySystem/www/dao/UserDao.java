package com._LibrarySystem.www.dao;

import com._LibrarySystem.www.bean.User;
import com._LibrarySystem.www.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static List<User> queryAll() throws SQLException {
        String SQL = "select id,username,password from library.user";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        User user;
        while (resultSet.next()){
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            userList.add(user);
        }
        DBUtil.close(connection,preparedStatement,resultSet);
        return userList;
    }

    public static boolean add(User user) throws SQLException{
        String SQL = "insert into library.user (id, username, password) value (?,?,?)";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,user.getId());
        preparedStatement.setString(2,user.getUsername());
        preparedStatement.setString(3,user.getPassword());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }

    public static boolean delete(User user) throws SQLException{
        String SQL = "delete from library.user where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,user.getId());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }
}
