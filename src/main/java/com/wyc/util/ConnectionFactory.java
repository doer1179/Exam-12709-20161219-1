package com.wyc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	private static final ConnectionFactory factory= new  ConnectionFactory();
	
	private Connection conn;
	static {
		
		Properties prop = new Properties();
		
		try {
			
			InputStream in = ConnectionFactory.class.getClassLoader()
				.getResourceAsStream("dbconfig.properties");	
		
			prop.load(in);
			driver=prop.getProperty("jdbc.driver");
			dburl=prop.getProperty("jdbc.dburl");
			user=prop.getProperty("jdbc.user");
			password=prop.getProperty("jdbc.password");
			Class.forName(driver);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("=======数据库连接异常=======");
		}
		
		
		
	}
	
	private ConnectionFactory(){
		
	}
	
	public static ConnectionFactory getInstance(){
	//	return factory;
		return new ConnectionFactory();
	}
	
	public Connection makeConnection(){
		
		try {
			
			conn=DriverManager.getConnection(dburl,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}























