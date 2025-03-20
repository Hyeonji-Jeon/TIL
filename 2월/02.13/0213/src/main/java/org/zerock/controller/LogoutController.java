package org.zerock.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie[] cks = request.getCookies();
		
		//login, views 
		Cookie loginCookie = new Cookie("login","");
		loginCookie.setMaxAge(0);
		loginCookie.setPath("/");
		
		response.addCookie(loginCookie);
		
		//login, views 
		Cookie viewsCookie = new Cookie("views","1");
		viewsCookie.setMaxAge(0);
		viewsCookie.setPath("/");
		
		response.addCookie(viewsCookie);
		
		response.sendRedirect("/login");
	}



}
