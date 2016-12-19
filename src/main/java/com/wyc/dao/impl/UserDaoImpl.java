package com.wyc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wyc.dao.UserDao;

public class UserDaoImpl implements UserDao {


	@Override
	public int LoginConfirm(Connection conn, String first_name)throws SQLException {
		
		PreparedStatement ps=conn.prepareStatement("SELECT COUNT(1) FROM customer WHERE first_name=?");
		
		ps.setString(1, first_name);

		ResultSet rs=ps.executeQuery();

		int count=0;
		if(rs.next()){
		count=rs.getInt("COUNT(1)");
		}
		return count;
	}

	

}
