package com.wyc.filter;

import java.io.IOException;

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

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("first_name");
		String url = req.getServletPath();
		if(object==null) {
			if(url.equals("/Exam-12709-20161219-1") || url.equals("jsp/index.jsp") || url.equals("/LoginServlet") || url.equals("jsp/login.jsp") || url.equals("/QueryFilmList")) {
				System.out.println("feibeiguolv");
				chain.doFilter(request, response);
			} else {
				System.out.println("OBJECT==NULL");
				System.out.println(object);
				req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
			}
		} else {
			System.out.println("OBJECT!wewer=NULL");
			chain.doFilter(request, response);
		}
		}
	@Override
	public void destroy() {

	}

}
