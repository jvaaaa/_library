package com._LibrarySystem.www.dao;

import com._LibrarySystem.www.bean.CategoryStaff;
import com._LibrarySystem.www.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryStaffDao {
    public static List<CategoryStaff> queryAll() throws SQLException {
        List<CategoryStaff> categoryStaffList = new ArrayList<>();
        String SQL = "select id,name,gender,contact,categoryID,telephone from library.categorystaff";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            CategoryStaff categoryStaff = new CategoryStaff();
            categoryStaff.setId(resultSet.getInt("id"));
            categoryStaff.setName(resultSet.getString("name"));
            categoryStaff.setGender(resultSet.getString("gender"));
            categoryStaff.setContact(resultSet.getString("contact"));
            categoryStaff.setCategoryID(resultSet.getInt("categoryID"));
            categoryStaff.setTelephone(resultSet.getString("telephone"));
            categoryStaffList.add(categoryStaff);
        }
        DBUtil.close(connection,preparedStatement,resultSet);
        return categoryStaffList;
    }

    public static CategoryStaff query(int id) throws SQLException {
        CategoryStaff categoryStaff = new CategoryStaff();
        String SQL = "select id,name,gender,contact,categoryID,telephone from library.categorystaff where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            categoryStaff.setId(resultSet.getInt("id"));
            categoryStaff.setName(resultSet.getString("name"));
            categoryStaff.setGender(resultSet.getString("gender"));
            categoryStaff.setContact(resultSet.getString("contact"));
            categoryStaff.setCategoryID(resultSet.getInt("categoryID"));
            categoryStaff.setTelephone(resultSet.getString("telephone"));
        }
        DBUtil.close(connection,preparedStatement,resultSet);
        return categoryStaff;
    }

    public static boolean add(CategoryStaff categoryStaff) throws SQLException{
        String SQL = "insert into library.categorystaff (id, name, gender, contact, categoryID, telephone) VALUE (?,?,?,?,?,?)";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,categoryStaff.getId());
        preparedStatement.setString(2,categoryStaff.getName());
        preparedStatement.setString(3,categoryStaff.getGender());
        preparedStatement.setString(4,categoryStaff.getContact());
        preparedStatement.setInt(5,categoryStaff.getCategoryID());
        preparedStatement.setString(6,categoryStaff.getTelephone());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }

    public static boolean delete(CategoryStaff categoryStaff) throws SQLException{
        String SQL = "delete from library.categorystaff where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,categoryStaff.getId());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }
}
