package exp1.dao;

import exp1.bean.Curator;
import exp1.bean.User;
import exp1.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuratorDao {

    public static List<Curator> queryAll() throws SQLException{
        String SQL = "select id,name,gender,telephone,email from library.curator";
        Connection connection = new DBUtil().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Curator> curatorList = new ArrayList<>();
        Curator curator;
        while (resultSet.next()){
            curator = new Curator();
            curator.setId(resultSet.getInt("id"));
            curator.setName(resultSet.getString("name"));
            curator.setGender(resultSet.getString("gender"));
            curator.setTelephone(resultSet.getString("telephone"));
            curator.setEmail(resultSet.getString("email"));
            curatorList.add(curator);
        }
        DBUtil.close(connection,preparedStatement,resultSet);
        return curatorList;
    }

    public static boolean contain(User user) throws SQLException{
        List<Curator> curatorList = queryAll();
        for (Curator curator : curatorList){
            if (curator.getId() == user.getId()){
                return true;
            }
        }
        return false;
    }
}
