package com._LibrarySystem.www.dao;

import com._LibrarySystem.www.bean.Category;
import com._LibrarySystem.www.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public static List<Category> queryAll() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        String SQL = "select id,name from library.category";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Category category = new Category();
            category.setId(resultSet.getInt("id"));
            category.setName(resultSet.getString("name"));
            categoryList.add(category);
        }
        DBUtil.close(connection,preparedStatement,resultSet);
        return categoryList;
    }

    public static boolean add(Category category)throws SQLException {
        String SQL = "insert into library.category (id, name) value (?,?)";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,category.getId());
        preparedStatement.setString(2,category.getName());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }

    public static boolean delete(Category category) throws SQLException{
        String SQL = "delete from library.category where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,category.getId());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }
}
