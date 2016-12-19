package com.wyc.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyc.dao.FilmDao;
import com.wyc.dao.impl.FilmDaoImpl;

public class DeleteOne extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FilmDao filmDao=new FilmDaoImpl();
		
		String forward=null;
		
		String s= req.getParameter("film_id");
		int film_id=Integer.valueOf(s);
		
		try {
			filmDao.DeleteOne(film_id);
			
			forward="jsp/deleteSuccess.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
