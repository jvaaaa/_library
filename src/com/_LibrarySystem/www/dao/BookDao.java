package com._LibrarySystem.www.dao;

import com._LibrarySystem.www.bean.Book;
import com._LibrarySystem.www.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public static List<Book> queryAll() throws SQLException {
        List<Book> bookList = new ArrayList<>();
        String SQL = "select id,ISBN,name,category,number,price,author from library.book";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setISBN(resultSet.getString("ISBN"));
            book.setName(resultSet.getString("name"));
            book.setCategory(resultSet.getString("category"));
            book.setNumber(resultSet.getInt("number"));
            book.setPrice(resultSet.getDouble("price"));
            book.setAuthor(resultSet.getString("author"));
            bookList.add(book);
        }
        DBUtil.close(connection,preparedStatement,resultSet);
        return bookList;
    }

    public static Book query(int id) throws SQLException{
        Book book = new Book();
        String SQL = "select id,ISBN,name,category,number,price,author from library.book where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            book.setId(resultSet.getInt("id"));
            book.setISBN(resultSet.getString("ISBN"));
            book.setName(resultSet.getString("name"));
            book.setCategory(resultSet.getString("category"));
            book.setNumber(resultSet.getInt("number"));
            book.setPrice(resultSet.getDouble("price"));
            book.setAuthor(resultSet.getString("author"));
        }
        DBUtil.close(connection, preparedStatement, resultSet);
        return book;
    }

    public static boolean add(Book book) throws SQLException{
        String SQL = "insert into library.book (id,ISBN,name,category,number,price,author) values (?,?,?,?,?,?,?)";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2,book.getISBN());
        preparedStatement.setString(3,book.getName());
        preparedStatement.setString(4,book.getCategory());
        preparedStatement.setInt(5,book.getNumber());
        preparedStatement.setDouble(6,book.getPrice());
        preparedStatement.setString(7,book.getAuthor());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }

    public static boolean delete(Book book) throws SQLException{
        String SQL = "delete from library.book where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,book.getId());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }

    public static boolean modify(Book book, String state, String statement) throws SQLException{
        String SQL = "update library.book set "+state+" = ? where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1,statement);
        preparedStatement.setInt(2,book.getId());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }

    public static boolean modify(Book book, String state, int number) throws SQLException{
        String SQL = "update library.book set "+state+" = ? where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,number);
        preparedStatement.setInt(2,book.getId());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }

    public static boolean modify(Book book, String state, double price) throws SQLException{
        String SQL = "update library.book set "+state+" = ? where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setDouble(1,price);
        preparedStatement.setInt(2,book.getId());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }

    public static boolean borrow(Book book) throws SQLException{
        Book book1 = query(book.getId());
        String SQL = "update library.book set number = ? where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,book1.getNumber()-1);
        preparedStatement.setInt(2,book.getId());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }

    public static boolean revert(Book book) throws SQLException{
        Book book1 = query(book.getId());
        String SQL = "update library.book set number = ? where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,book1.getNumber()+1);
        preparedStatement.setInt(2,book.getId());
        int success = preparedStatement.executeUpdate();
        DBUtil.close(connection,preparedStatement);
        return success==1;
    }
}
