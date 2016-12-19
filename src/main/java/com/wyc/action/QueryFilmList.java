package com.wyc.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyc.dao.FilmDao;
import com.wyc.dao.impl.FilmDaoImpl;
import com.wyc.entity.Film;
import com.wyc.util.ConnectionFactory;

public class QueryFilmList extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FilmDao filmDao = new FilmDaoImpl();
		ConnectionFactory factory = ConnectionFactory.getInstance();
		
		Connection conn=factory.makeConnection();
		
		String forward=null;
		
		try {
			List<Film> l=filmDao.QueryFilm(conn);
			
			/*
			 * ���Ի�ȡ����FilmList���ں�̨���
			 * 
			 * *Iterator<Film> it=null;
			for (it=l.iterator();it.hasNext();) {
				Film f = it.next();
				System.out.println(f.getFilm_id()+f.getDescription()+f.getLanguage()+f.getTitle());
			}*/
			
			req.setAttribute("film_list",l);
			RequestDispatcher rd = req.getRequestDispatcher("jsp/filmList.jsp");
			rd.forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
