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
import com.wyc.entity.Language;
import com.wyc.util.ConnectionFactory;

public class GoToAddFilmServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LanguageDao languageDao = new LanguageDaoImpl();
		
		Connection conn= ConnectionFactory.getInstance().makeConnection();
		
		String forward=null;
		
		List<Language>list=new ArrayList<>();
		
		try {
			list=languageDao.GetLanguageList(conn);
			
			req.setAttribute("languageList", list);
			
			forward="jsp/addFilm.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
