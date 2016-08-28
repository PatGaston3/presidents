//package web;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PresLogic {
//	private static final String INPUT_FILE = "presidents.csv";
//	private static final String QUOTES = "quotes.csv";
//	private List<President> presidents = new ArrayList<>();
//
//	public void parse() {
//		try (BufferedReader buf = new BufferedReader(new FileReader(INPUT_FILE))) {
//			String line;
//			while ((line = buf.readLine()) != null) {
//				President p = buildPresident(line);
//				presidents.add(p);
//			}
//
//		} catch (IOException e) {
//			System.err.println(e);
//		}
//
//	}
//
//	private President buildPresident(String line) {
//		String[] tokens = line.split(",");
//		int number = Integer.parseInt(tokens[0].trim());
//		String fname = tokens[1].trim();
//		String mname = tokens[2].trim();
//		String lname = tokens[3].trim();
//		int[] termArray = getTerms(tokens[4].trim());
//		String party = tokens[5].trim();
//
//		return new President(number, fname, mname, lname, termArray[0], termArray[1], party);
//	}
//	private void parseQuote(){
//		int count = 0;
//		try(	BufferedReader buf2 = new BufferedReader(new FileReader(QUOTES))) {
//			String line2;
//			while((line2 = buf2.readLine()) != null) {
//				
//				presidents.get(count).setQuote(line2);;
//			}
//	}
//		catch(IOException e){
//			System.err.println(e);
//		}
//	}
//
//	private int[] getTerms(String terms) {
//		// The terms are separated by a dash
//		String[] termTokens = terms.split("-");
//		int startTerm = Integer.parseInt(termTokens[0]);
//		int endTerm = Integer.parseInt(termTokens[1]);
//		return new int[] { startTerm, endTerm };
//	}
//
//	public List<President> getPresidents() {
//		return presidents;
//	}
//}
