package com.wyc.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyc.dao.FilmDao;
import com.wyc.dao.impl.FilmDaoImpl;
import com.wyc.entity.Film;
import com.wyc.util.ConnectionFactory;

public class AddFilmServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FilmDao filmDao = new FilmDaoImpl();
		
		Connection conn= ConnectionFactory.getInstance().makeConnection();
		
		String forward=null;
		
		Film film=null;
		
		String title=req.getParameter("title");
		String description = req.getParameter("description");
		
		String lang = req.getParameter("language_id");
		int language_id=Integer.valueOf(lang);
		
		try {
			filmDao.AddFilm(conn, title, description, language_id);
			
			forward="/";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		} catch (SQLException e) {
			System.out.println("新增film数据异常");
			e.printStackTrace();
		}
		
		
	}
}
