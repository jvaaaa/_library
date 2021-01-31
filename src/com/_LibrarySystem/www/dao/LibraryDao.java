package com._LibrarySystem.www.dao;

import com._LibrarySystem.www.bean.Library;
import com._LibrarySystem.www.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDao {

    public static List<Library> queryAll() throws SQLException {
        List<Library> libraryList = new ArrayList<>();
        String SQL = "select id,name,address,CuratorID from library.library";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Library library = new Library();
            library.setId(resultSet.getInt("id"));
            library.setName(resultSet.getString("name"));
            library.setAddress(resultSet.getString("address"));
            library.setCuratorID(resultSet.getInt("CuratorID"));
            libraryList.add(library);
        }
        DBUtil.close(connection,preparedStatement,resultSet);
        return libraryList;
    }

    public static Library query(int id) throws SQLException{
        Library library = new Library();
        String SQL = "select id,name,address,CuratorID from library.library where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            library.setId(resultSet.getInt("id"));
            library.setName(resultSet.getString("name"));
            library.setAddress(resultSet.getString("address"));
            library.setCuratorID(resultSet.getInt("CuratorID"));
        }
        DBUtil.close(connection,preparedStatement,resultSet);
        return library;
    }

    public static boolean add(Library library) throws SQLException{
        String SQL = "insert into library.library (id, name, address, CuratorID) values (?,?,?,?);";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,library.getId());
        preparedStatement.setString(2,library.getName());
        preparedStatement.setString(3,library.getAddress());
        preparedStatement.setInt(4,library.getCuratorID());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }
}
