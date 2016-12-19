package com.wyc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.processing.Filer;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wyc.dao.UserDao;
import com.wyc.dao.impl.UserDaoImpl;
import com.wyc.util.ConnectionFactory;

public class LoginServlet extends HttpServlet  {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String first_name=req.getParameter("first_name");
		
		UserDao userDao = new UserDaoImpl();
		
		Connection conn= ConnectionFactory.getInstance().makeConnection();
		
		String forward=null;
		try {
			int count= userDao.LoginConfirm(conn, first_name);
			
			if(count==1){
				req.getSession().setAttribute("first_name", first_name);
				forward="jsp/index.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(forward);
				rd.forward(req, resp);
			}else{
				
				forward="jsp/LoginError.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(forward);
				rd.forward(req, resp);
			}
		} catch (SQLException e) {
			System.out.println("登录操作出现异常");
			e.printStackTrace();
		}
	}
	


}
