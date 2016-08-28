package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RunMe")
public class PresidentServlet extends HttpServlet {
	private static final String filename = "WEB-INF/presidents.csv";
	private static final String QUOTES = "WEB_INF/quotes.csv";
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
		
		int saveTyping = Integer.parseInt(req.getParameter("input"))-1;
		
		HttpSession session = req.getSession();
		session.setAttribute("term", saveTyping);
		
		req.setAttribute("president", presDAO.getPresident(saveTyping));
		req.getRequestDispatcher("/results.jsp").forward(req, resp);

	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String previousPres = req.getParameter("button");
		
		HttpSession session = req.getSession();
		
		int newTerm;
				
		if (previousPres.equals("Previous")) {
			newTerm = (int)session.getAttribute("term") - 1;
		} else {
			newTerm = (int)session.getAttribute("term") + 1;
		}
		req.setAttribute("president", presDAO.getPresident(newTerm));
		session.setAttribute("term", newTerm);
		req.getRequestDispatcher("/results.jsp").forward(req, resp);
		
	}
}