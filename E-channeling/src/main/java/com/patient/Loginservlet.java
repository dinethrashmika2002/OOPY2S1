package com.patient;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usn=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		try {
			List<patient> pdetails=patientdbutil.validate(usn, pwd);
			request.setAttribute("pdetails", pdetails);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis=request.getRequestDispatcher("userprofile.jsp");
		dis.forward(request, response);
		
	}

}
