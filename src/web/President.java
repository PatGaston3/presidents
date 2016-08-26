package web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class President {
	// Fields
	private int termNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private int startYear;
	private int endYear;
	private String party;
	
	// Constructors
	public President() {}
	
	public President(int termNumber, String firstName, String middleName, 
			String lastName, int startYear, int endYear, String party) {
		this.termNumber = termNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		if (middleName == null) {
			this.middleName = "N/A";
		}
		this.lastName = lastName;
		this.startYear = startYear;
		this.endYear = endYear;
		this.party = party;
	}

	public int getTermNumber() {
		return termNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getStartYear() {
		return startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public String getParty() {
		return party;
	}
	
	public void displayPrez() {
//		System.out.printf("%4d %12s %16s %14s %10d %15d %25s", 
//				this.termNumber, this.firstName, this.middleName, this.lastName, this.startYear, this.endYear, this.party);
		System.out.println("TEST");
		System.out.println("Name: " + this.firstName);
		System.out.print(" " + this.middleName);
		System.out.print(" " + this.lastName);
		System.out.println("Start Year: " + this.startYear);
		System.out.println("End Year: " + this.endYear);
		System.out.println("Party: " + this.party);
	}
	

	@Override
	public String toString() {
		return "President [termNumber=" + termNumber + ", \nfirstName=" + firstName + ", \nmiddleName=" + middleName
				+ ", \nlastName=" + lastName + ", \nstartYear=" + startYear + ", \nendYear=" + endYear + ", \nparty=" + party
				+ "]";
	}
	
	
	
}
