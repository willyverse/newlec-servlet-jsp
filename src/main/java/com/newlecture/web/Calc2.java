package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		PrintWriter out = response.getWriter();
		
		String num_ = request.getParameter("num");
		String op = request.getParameter("operator");
		
		int num = 0;
		if(!num_.equals("")) num = Integer.parseInt(num_);
		
		// 계산
		if(op.equals("=")) {
			
//			int x = (Integer) application.getAttribute("num");
//			int x = (Integer) session.getAttribute("num");
			int x = 0;
			for(Cookie c : cookies) 
				if(c.getName().equals("num")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			int y = num;
			
//			String operator = (String) application.getAttribute("op");
//			String operator = (String) session.getAttribute("op");
			String operator = "";
			for(Cookie c : cookies) 
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			
			int result = 0;
			if(operator.equals("+")) {
				result = x + y;
			}
			else {
				result = x - y;
			}
			
			out.printf("the result is %d\n", result);
			 
		}
		// 값을 저장
		else {
//			application.setAttribute("num", num);
//			application.setAttribute("op", op);
//			session.setAttribute("num", num);
//			session.setAttribute("op", op);		
			
			Cookie valueCookie = new Cookie("num", String.valueOf(num));
			Cookie opCookie = new Cookie("op", op);
			
			valueCookie.setPath("/"); // valueCookie를 root로 가져감
			valueCookie.setMaxAge(24*60*60);
			
			opCookie.setPath("/calc2"); // opCookie를 /calc2로만 가져감
			
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html");
			}
	
	}
	
}
