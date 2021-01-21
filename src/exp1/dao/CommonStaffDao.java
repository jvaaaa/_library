package exp1.dao;

import exp1.bean.CommonStaff;
import exp1.bean.User;
import exp1.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommonStaffDao {

    public static boolean dispatch(CommonStaff commonStaff,String contact,int categoryID) throws SQLException{
        return false;//未写
    }

    public static boolean modify(CommonStaff commonStaff,String statement,String modify) throws SQLException{
        String SQL = "update library.commonstaff set "+statement+" = ? where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(2,commonStaff.getId());
        if (statement.equals("id")){
            if (Integer.parseInt(modify) <= 0){
                return false;
            }
            preparedStatement.setInt(1,Integer.parseInt(modify));
        }else {
            preparedStatement.setString(1,modify);
        }
        return (preparedStatement.executeUpdate() == 1);
    }

    public static boolean delete(CommonStaff commonStaff) throws SQLException{
        String SQL = "delete from library.commonstaff where id = ?";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,commonStaff.getId());
        return (preparedStatement.executeUpdate() == 1);
    }

    public static boolean add(CommonStaff commonStaff) throws SQLException{
        String SQL = "insert into library.commonstaff (id,name,gender,telephone) values (?,?,?,?)";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,commonStaff.getId());
        preparedStatement.setString(2,commonStaff.getName());
        preparedStatement.setString(3,commonStaff.getGender());
        preparedStatement.setString(4,commonStaff.getTelephone());
        return (preparedStatement.executeUpdate() == 1);
    }

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

    public static CommonStaff query(int id) throws SQLException{
        List<CommonStaff> list = queryAll();
        for (CommonStaff commonStaff : list){
            if (commonStaff.getId() == id){
                return commonStaff;
            }
        }
        return new CommonStaff();
    }

    public static boolean contain(User user) throws SQLException{
        List<CommonStaff> commonStaffList = queryAll();
        for (CommonStaff commonStaff : commonStaffList){
            if (commonStaff.getId() == user.getId()){
                return true;
            }
        }
        return false;
    }
}
