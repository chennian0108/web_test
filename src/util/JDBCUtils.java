package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private static String dirver = "com.mysql.jdbc.Driver";
	//private String url = "jdbc:mysql://localhost:3306/test?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=UTF8";
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String username = "root";
	private static String password = "root";
	
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;
	
	//insert update delete
	public static void executeDML(String sql){
		try {
			//1 注册驱动
			Class.forName(dirver);
			
			//2 获得连接
			conn = DriverManager.getConnection(url, username, password);
			
			//3 创建stmt对象
			stmt = conn.createStatement();
			
			//4 执行sql
			stmt.execute(sql);
			System.out.println("操作成功");
			//5 处理结果集(select操作)
		} catch (Exception e) {
			System.out.println("操作失败");
			e.printStackTrace();
		}finally {
			//6 关闭资源
			try {
				if(stmt!=null)stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static Object executeSelect(String sql,ResultHandler r){
		Object o = null;
		try {
			//1 注册驱动
			Class.forName(dirver);
			
			//2 获得连接
			conn = DriverManager.getConnection(url, username, password);
			
			//3 创建stmt对象
			stmt = conn.createStatement();
			
			//4 执行sql
			rs = stmt.executeQuery(sql);
			
			//5 处理结果集(select操作)
			
			o = r.handler(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6 关闭资源
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(stmt!=null)stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return o;
	}
	
}




