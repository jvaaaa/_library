package exp1.dao;

import exp1.bean.User;
import exp1.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class UserDao {

    public static boolean modify(User user,String statement,String modify)throws SQLException{
        String SQL = "update library.user set "+statement+" = ? where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(2,user.getId());
        if (statement.equals("id")){
            if (Integer.parseInt(modify) <= 0){
                throw new InputMismatchException();
            }
            preparedStatement.setInt(1,Integer.parseInt(modify));
        }
        preparedStatement.setString(1,modify);
        return (preparedStatement.executeUpdate() == 1);
    }

    public static boolean delete(User user) throws SQLException{
        String SQL = "delete from library.user where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,user.getId());
        return (preparedStatement.executeUpdate() == 1);
    }

    public static boolean add(User user) throws SQLException{
        String SQL = "insert into library.user (id,username,password) values (?,?,?)";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,user.getId());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3,user.getPassword());
        return (preparedStatement.executeUpdate() == 1);
    }

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
}
