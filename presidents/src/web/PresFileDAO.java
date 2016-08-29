package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class PresFileDAO implements PresDAO{

	private static final String filename = "WEB-INF/presidents.csv";
	private static final String QUOTES = "WEB-INF/quotes.csv";
	private ServletContext servletContext;
	private List<President> presidents;


	public PresFileDAO(ServletContext context) {
		servletContext = context;
		presidents = new ArrayList<>();
		loadPresidentsFromFile();
		parseQuote();
	}

	private void loadPresidentsFromFile() {
		InputStream is = servletContext.getResourceAsStream(filename);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
				President p = buildPresident(line);
				presidents.add(p);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private void parseQuote() {
		InputStream is = servletContext.getResourceAsStream(QUOTES);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			int counter = 0;
			while ((line = buf.readLine()) != null) {
				presidents.get(counter).setQuote(line);
				counter ++;
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	private President buildPresident(String line) {
		String[] tokens = line.split(",");
		int number = Integer.parseInt(tokens[0].trim());
		String fname = tokens[1].trim();
		String mname = tokens[2].trim();
		String lname = tokens[3].trim();
		int[] termArray = getTerms(tokens[4].trim());
		String party = tokens[5].trim();

		return new President(number, fname, mname, lname, termArray[0], termArray[1], party);
	}

	private int[] getTerms(String terms) {
		// The terms are separated by a dash
		String[] termTokens = terms.split("-");
		int startTerm = Integer.parseInt(termTokens[0]);
		int endTerm = Integer.parseInt(termTokens[1]);
		return new int[] { startTerm, endTerm };
	}

	
	public President getPresident(int term) {
		return presidents.get(term); 
	}
	
	
	
	public List<President> getPresidents() {
		return presidents;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void setPresidents(List<President> presidents) {
		this.presidents = presidents;
	}

}

			
		
	
