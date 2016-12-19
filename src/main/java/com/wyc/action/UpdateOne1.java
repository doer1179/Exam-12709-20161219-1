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

public class UpdateOne1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		getlanguage(req, resp);
		
		FilmDao filmDao = new FilmDaoImpl();
		
		String forward=null;
		
		String s= req.getParameter("film_id");
		
		int film_id=Integer.valueOf(s);
		
	
		try {
			
			Film film=filmDao.UpdateOne1(film_id);

			
			req.setAttribute("film",film);
			
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/updateFilm.jsp");
			rd.forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getlanguage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LanguageDao languageDao = new LanguageDaoImpl();
		
		List<Language>list=new ArrayList<>();
		
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		try {
			list=languageDao.GetLanguageList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("LanguageList", list);
	}
}
