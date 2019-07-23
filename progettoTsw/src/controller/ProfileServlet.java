package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/Profilo")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = (String) request.getSession().getAttribute("type");
		if(type == null) {
			RequestDispatcher rd = request.getRequestDispatcher("view/html-jsp/login.jsp");
			rd.forward(request, response);
		}
		else if(type.equals("utente"))
			request.getRequestDispatcher("view/html-jsp/profiloUser.jsp").forward(request, response);
		else request.getRequestDispatcher("view/html-jsp/profiloRisto.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
