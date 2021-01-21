package com._LibrarySystem.www.dao;

import com._LibrarySystem.www.bean.CommonStaff;
import com._LibrarySystem.www.bean.User;
import com._LibrarySystem.www.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommonStaffDao {

    public static List<CommonStaff> queryAll() throws SQLException {
        String SQL = "select id,name,gender,telephone from library.commonstaff";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CommonStaff> commonStaffList = new ArrayList<>();
        CommonStaff commonStaff;
        while (resultSet.next()){
            commonStaff = new CommonStaff();
            commonStaff.setId(resultSet.getInt("id"));
            commonStaff.setName(resultSet.getString("name"));
            commonStaff.setGender(resultSet.getString("gender"));
            commonStaff.setTelephone(resultSet.getString("telephone"));
            commonStaffList.add(commonStaff);
        }
        DBUtil.close(connection,preparedStatement,resultSet);
        return commonStaffList;
    }

    public static boolean contain(User user) throws SQLException {
        List<CommonStaff> commonStaffList = queryAll();
        for (CommonStaff commonStaff : commonStaffList){
            if (commonStaff.getId() == user.getId()){
                return true;
            }
        }
        return false;
    }

    public static CommonStaff query(int id) throws SQLException{
        CommonStaff commonStaff = new CommonStaff();
        String SQL = "select id,name,gender,telephone from library.commonstaff where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            commonStaff.setId(resultSet.getInt("id"));
            commonStaff.setName(resultSet.getString("name"));
            commonStaff.setGender(resultSet.getString("gender"));
            commonStaff.setTelephone(resultSet.getString("telephone"));
        }
        DBUtil.close(connection, preparedStatement, resultSet);
        return commonStaff;
    }

    public static boolean add(CommonStaff commonStaff) throws SQLException{
        String SQL = "insert into library.commonstaff (id,name,gender,telephone) values (?,?,?,?)";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,commonStaff.getId());
        preparedStatement.setString(2,commonStaff.getName());
        preparedStatement.setString(3, commonStaff.getGender());
        preparedStatement.setString(4,commonStaff.getTelephone());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }
}
