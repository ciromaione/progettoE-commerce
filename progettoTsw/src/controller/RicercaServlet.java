package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ristorante;
import model.RistoranteDAO;


@WebServlet("/Ricerca")
public class RicercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String text = request.getParameter("sb-text");;
		RistoranteDAO rd = new RistoranteDAO();
		ArrayList<Ristorante> ristoranti = rd.doRetriveByText(text);
				
		request.setAttribute("ristoranti", ristoranti);
		request.getRequestDispatcher("view/html-jsp/ricerca.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
