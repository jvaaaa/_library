package com._LibrarySystem.www.dao;

import com._LibrarySystem.www.bean.Administrator;
import com._LibrarySystem.www.bean.User;
import com._LibrarySystem.www.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDao {

    public static boolean contain(User user) throws SQLException {
        List<Administrator> administratorList = queryAll();
        for (Administrator administrator : administratorList){
            if (administrator.getId() == user.getId()){
                return true;
            }
        }
        return false;
    }

    public static List<Administrator> queryAll() throws SQLException{
        List<Administrator> administratorList = new ArrayList<>();
        String SQL = "select id,name,telephone,email from library.administrator";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Administrator administrator = new Administrator();
            administrator.setId(resultSet.getInt("id"));
            administrator.setName(resultSet.getString("name"));
            administrator.setTelephone(resultSet.getString("telephone"));
            administrator.setEmail(resultSet.getString("email"));
            administratorList.add(administrator);
        }
        DBUtil.close(connection,preparedStatement,resultSet);
        return administratorList;
    }
}
