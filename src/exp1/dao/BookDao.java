package exp1.dao;

import exp1.bean.Book;
import exp1.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public static boolean revert(Book book) throws SQLException{
        int number;
        String SQL = "select number from library.book where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,book.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            number = resultSet.getInt("number");
            if(modify(book,"number",String.valueOf(number+1))){
                return true;
            }
        }
        return false;
    }

    public static boolean borrow(Book book) throws SQLException{
        int number;
        String SQL = "select number from library.book where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,book.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            number = resultSet.getInt("number");
            if (number == 0){
                return false;
            }
            else {
                if(modify(book,"number",String.valueOf(number-1))){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean modify(Book book,String statement,String modify) throws SQLException{
        String SQL = "update library.book set "+statement+" = ? where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(2,book.getId());
        switch (statement) {
            case "id": {
                if (Integer.parseInt(modify) <= 0) {
                    return false;
                }
                preparedStatement.setInt(1, Integer.parseInt(modify));
                break;
            }
            case "number": {
                if (Integer.parseInt(modify) < 0) {
                    return false;
                }
                preparedStatement.setInt(1, Integer.parseInt(modify));
                break;
            }
            case "price":
                if (Double.parseDouble(modify) < 0) {
                    return false;
                }
                preparedStatement.setDouble(1, Double.parseDouble(modify));
                break;
            default:
                preparedStatement.setString(1, modify);
                break;
        }
        return (preparedStatement.executeUpdate()==1);
    }

    public static boolean delete (Book book) throws SQLException{
        String SQL = "delete from library.book where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,book.getId());
        return (preparedStatement.executeUpdate()==1);
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
        return (preparedStatement.executeUpdate() == 1);
    }

    public static List<Book> query(String SQL,String statement) throws SQLException{
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1,statement);
        List<Book> bookList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        Book book;
        while (resultSet.next()){
            book = new Book();
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
}
