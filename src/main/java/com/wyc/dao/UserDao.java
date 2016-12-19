package com.wyc.dao;

import java.sql.Connection;
import java.sql.SQLException;


public interface UserDao {
	public int LoginConfirm(Connection conn,String first_name)throws SQLException;

	//public int GetUserId(Connection conn,String username,String password) throws SQLException;

}



