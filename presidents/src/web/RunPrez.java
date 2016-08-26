package web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunPrez {
	List<President> presidents = new ArrayList<>();
	public static void main(String[] args) {
		RunPrez rp = new RunPrez();
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
	
	public void noMiddleName() {
		System.out.println("Term:\tFirst Name:\tMiddle Name:\tLast Name:\tStart Yr:\tEnd Yr:\t\t\tParty:");
		for (President president : presidents) {
			if (president.getMiddleName().equalsIgnoreCase("")) {
				president.displayPrez();
				System.out.println("");
			}
		}
	}
	
	public void lessThanFour() {
		System.out.println("Term:\tFirst Name:\tMiddle Name:\tLast Name:\tStart Yr:\tEnd Yr:\t\t\tParty:");
		for (President president : presidents) {
			if (president.getEndYear() - president.getStartYear() < 4 ) {
				president.displayPrez();
				System.out.println("");
			}
		}
	}
	
	public void lastNameR() {
		System.out.println("Term:\tFirst Name:\tMiddle Name:\tLast Name:\tStart Yr:\tEnd Yr:\t\t\tParty:");
		for (President president : presidents) {
			if (president.getLastName().startsWith("R")) {
				president.displayPrez();
				System.out.println("");
			}
		}
	}
	
	public void jamesOrGeorge() {
		System.out.println("Term:\tFirst Name:\tMiddle Name:\tLast Name:\tStart Yr:\tEnd Yr:\t\t\tParty:");
		for (President president : presidents) {
			if (president.getFirstName().equalsIgnoreCase("James") || president.getFirstName().equalsIgnoreCase("George")) {
				president.displayPrez();
				System.out.println("");
			}
		}
	}
	
	public RunPrez() {
		try {
			// call BufferedReader Object to read line by line and FileRead (plain text) the "presidents.csv" file
			BufferedReader buffPrez = new BufferedReader(new FileReader("presidents.txt"));
			
			// create new ArrayList of president objects
			
			String newLine;
			while ((newLine = buffPrez.readLine()) != null ){
				String[] presArray = newLine.split(" ");
//				for (String string : presArray) {
//					System.out.println(string);
//					System.out.println("");
//				}
				if (presArray.length == 7) {
					String[] years = presArray[5].split("-");
					presidents.add(new President(Integer.parseInt(presArray[0]),
							presArray[1], presArray[2] + "-" + presArray[3], presArray[4],
							(Integer.parseInt(years[0])), (Integer.parseInt(years[1])),
							presArray[6]));
				}
				if (presArray.length == 5) {
					if (presArray[4].startsWith("1993")) {
//						String[] splityears = presArray[4].split("(");
//						String[] years = splityears[0].split("-");
						//years[1] = "Democrat";
						presidents.add(new President(Integer.parseInt(presArray[0]),
								presArray[1], "null", presArray[2],
								1993, 2001,
								"(Democrat)"));
					}
					else {
						String[] years = presArray[3].split("-");
						presidents.add(new President(Integer.parseInt(presArray[0]),
								presArray[1],"null", presArray[2],
								(Integer.parseInt(years[0])), (Integer.parseInt(years[1])),
								presArray[4]));
					}
					}
				else {
					continue;
				}
			}
			System.out.println("Term:\tFirst Name:\tMiddle Name:\tLast Name:\tStart Yr:\tEnd Yr:\t\t\tParty:");
			for (President president : presidents) {
				president.displayPrez();
				System.out.println("");
				
			}
//			}
			}catch(
					IOException e)
			{
				System.err.println(e);
			}

			}}
