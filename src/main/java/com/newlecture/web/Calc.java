package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		String[] num_ = request.getParameterValues("num");
		String op = request.getParameter("operator");
		
		int result = 0;
		
		if(op.equals("µ¡¼À"))	 {
			for(int i=0; i<num_.length; i++) {
				int num = Integer.parseInt(num_[i]);
				result += num;
			}
			out.println("result is " + result);
			}
		else {
			for(int i=0; i<num_.length; i++) {
				int num = Integer.parseInt(num_[i]);
				result -= num;
			}
			out.println("result is " + result);
			}
	
	}
	
}
