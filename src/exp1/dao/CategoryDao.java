package exp1.dao;

import exp1.bean.Category;
import exp1.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDao {

    public static boolean delete(Category category) throws SQLException {
        String SQL = "delete from library.category where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,category.getId());
        return (preparedStatement.executeUpdate() == 1);
    }

    public static boolean add(Category category) throws SQLException {
        String SQL = "insert into library.category (id,name) values (?,?)";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,category.getId());
        preparedStatement.setString(2, category.getName());
        return (preparedStatement.executeUpdate()== 1);
    }
}
