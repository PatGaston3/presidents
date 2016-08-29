package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/RunMe")
public class PresidentServlet extends HttpServlet {
//	private static final String filename = "WEB-INF/presidents.csv";
//	private static final String QUOTES = "WEB_INF/quotes.csv";
//	private ServletContext servletContext;
	private PresDAO presDAO;
	
	public void init() throws ServletException {
		System.out.println("In init method");
		
		presDAO = new PresFileDAO(getServletContext());
	}		

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	System.out.println("Doing a GET");
		
	//	List<President> output = presDAO.getPresidents();
		
		int saveTyping = 0;
//		int saveTyping = Integer.parseInt(req.getParameter("input"))-1;
		
		HttpSession session = req.getSession();
		session.setAttribute("term", saveTyping);
		
		req.setAttribute("president", presDAO.getPresident(saveTyping));
		req.getRequestDispatcher("/initial.jsp").forward(req, resp);

	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String term = req.getParameter("input");
		String previousPres = req.getParameter("button");
		int newTerm;
		if (term != null){ //term form was used
			newTerm = Integer.parseInt(term)-1;
		}
		
		else if (previousPres.equals("Previous")) {
			newTerm = (int)session.getAttribute("term") - 1;
		} else {
			newTerm = (int)session.getAttribute("term") + 1;
		}
		req.setAttribute("president", presDAO.getPresident(newTerm));
		session.setAttribute("term", newTerm);
		req.getRequestDispatcher("/initial.jsp").forward(req, resp);
		
	}
}