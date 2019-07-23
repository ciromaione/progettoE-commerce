package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import model.ProdottoDAO;

/**
 * Servlet implementation class AddRemToMenu
 */
@WebServlet("/AddRemToMenu")
public class AddRemToMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submit = request.getParameter("submit");
		ProdottoDAO pd = new ProdottoDAO();
		if(submit.equals("-")) {
			String idPiatto = request.getParameter("id-piatto");
			pd.doRemoveById(Integer.parseInt(idPiatto));
		}
		else {
			String nome = request.getParameter("nome");
			String desc = request.getParameter("desc");
			int idCat = Integer.parseInt(request.getParameter("cat"));
			int idRisto = Integer.parseInt(request.getParameter("idRisto"));
			String prezzo = request.getParameter("prezzo");
			if(Pattern.matches("[0-9]+(,|.)[0-9]{2}", prezzo)) {
				prezzo = prezzo.replace(',', '.');
				int prezzoCent = (int)(Float.parseFloat(prezzo)*100);
				Prodotto p = new Prodotto();
				p.setNome(nome);
				p.setDescrizione(desc);
				p.setIdCat(idCat);
				p.setIdRisto(idRisto);
				p.setPrezzoCent(prezzoCent);
				pd.doSave(p);
			}
			
		}
		request.setAttribute("ilTuoMenu", "true");
		request.getRequestDispatcher("Profilo").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
