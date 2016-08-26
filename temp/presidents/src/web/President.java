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
	private String display;
	
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
		this.display = termNumber + " " + firstName + " " + middleName + 
			" " + lastName + " " + startYear + "-" + endYear + " " + party; 
		
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
	
	public String getDisplay() {
		return display;
	}
	

	@Override
	public String toString() {
		return "President [termNumber=" + termNumber + ", \nfirstName=" + firstName + ", \nmiddleName=" + middleName
				+ ", \nlastName=" + lastName + ", \nstartYear=" + startYear + ", \nendYear=" + endYear + ", \nparty=" + party
				+ "]";
	}
	
}
