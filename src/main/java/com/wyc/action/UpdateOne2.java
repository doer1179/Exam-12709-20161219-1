package com.wyc.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyc.dao.FilmDao;
import com.wyc.dao.LanguageDao;
import com.wyc.dao.impl.FilmDaoImpl;
import com.wyc.dao.impl.LanguageDaoImpl;
import com.wyc.entity.Film;
import com.wyc.entity.Language;
import com.wyc.util.ConnectionFactory;

public class UpdateOne2 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FilmDao filmDao = new FilmDaoImpl();
		
		String forward=null;
		
		String s=req.getParameter("film_id");
		int film_id=Integer.valueOf(s);
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String str=req.getParameter("language_id");
		int language_id=Integer.valueOf(str);
		
		Film film = new Film(film_id,title,description,null);
		
		try {
		
			filmDao.UpdateOne2(film, language_id);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/updateSuccess.jsp");
			rd.forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
