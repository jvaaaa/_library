package exp1.util;

import java.sql.*;

public class DBUtil {
	// 数据库连接路径
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_books?"
			+ "allowPublicKeyRetrieval=true"
			+ "& useUnicode = true & serverTimezone = GMT"
			// MySQL在高版本需要指明是否进行SSL连接
			+ "& characterEncoding = utf8 & useSSL = false";
	private static final String NAME = "root";
	private static final String PASSWORD = "root";
	private static Connection conn = null;
	static {
		try {
			// 加载驱动程序
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public DBUtil() {
		try {
			// 获取数据库的连接
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
	 // 对外提供一个方法来获取数据库连接
	 public static Connection getConnection(){
		 return conn;	   
	 }

	public static void close (Connection connection, Statement statement, ResultSet resultSet){
		closeConnection(connection);
		closeStatement(statement);
		closeResultSet(resultSet);
	}

	private static void closeConnection(Connection connection){
		try {
			if (connection!=null){
				connection.close();
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			connection = null;
		}
	}

	private static void closeResultSet(ResultSet resultSet){
		try {
			if (resultSet!=null){
				resultSet.close();
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			resultSet = null;
		}
	}

	private static void closeStatement(Statement statement){
		try {
			if (statement!=null){
				statement.close();
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			statement = null;
		}
	}
}
