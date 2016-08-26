package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RunMe")
public class PresidentServlet extends HttpServlet {
	private static final String filename = "presidents.csv";
	private ServletContext servletContext;
	List<President> presidents = new ArrayList<>();

	public void init() throws ServletException {
		try {
			// call BufferedReader Object to read line by line and FileRead
			// (plain text) the "presidents.csv" file
			InputStream is = servletContext.getResourceAsStream(filename);
			BufferedReader buffPrez = new BufferedReader(new InputStreamReader(is));

			// create new ArrayList of president objects

			String newLine;
			while ((newLine = buffPrez.readLine()) != null) {
				String[] presArray = newLine.split(" ");
				// for (String string : presArray) {
				// System.out.println(string);
				// System.out.println("");
				// }
				if (presArray.length == 7) {
					String[] years = presArray[5].split("-");
					presidents.add(new President(Integer.parseInt(presArray[0]), presArray[1],
							presArray[2] + "-" + presArray[3], presArray[4], (Integer.parseInt(years[0])),
							(Integer.parseInt(years[1])), presArray[6]));
				}
				if (presArray.length == 5) {
					if (presArray[4].startsWith("1993")) {
						// String[] splityears = presArray[4].split("(");
						// String[] years = splityears[0].split("-");
						// years[1] = "Democrat";
						presidents.add(new President(Integer.parseInt(presArray[0]), presArray[1], "null", presArray[2],
								1993, 2001, "(Democrat)"));
					} else {
						String[] years = presArray[3].split("-");
						presidents.add(new President(Integer.parseInt(presArray[0]), presArray[1], "null", presArray[2],
								(Integer.parseInt(years[0])), (Integer.parseInt(years[1])), presArray[4]));
					}
				} else {
					continue;
				}
			}
			System.out.println("Term:\tFirst Name:\tMiddle Name:\tLast Name:\tStart Yr:\tEnd Yr:\t\t\tParty:");
			for (President president : presidents) {
				president.displayPrez();
				System.out.println("");

			}
			// }
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	public void displayWhigs() {
		System.out.println("Term:\tFirst Name:\tMiddle Name:\tLast Name:\tStart Yr:\tEnd Yr:\t\t\tParty:");
		for (President president : presidents) {
			if (president.getParty().equalsIgnoreCase("Whig")) {
				president.displayPrez();
				System.out.println("");
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PresidentServlet operate = new PresidentServlet();
		operate.init();
		
		List<President> output = new ArrayList<>();
		
		for (President president: presidents) {
			output.add(president);
		}
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head><title>Presidents</title></head>");
		pw.println(" <body>" + output + " </body>");
		pw.println(" </html>");
		pw.close();
	}

	

}