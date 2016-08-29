package web;

public class President {
	// Fields
	private int termNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private int startYear;
	private int endYear;
	private String party;
	private String quote;
	private String displayName;
	private String displayInfo;
	private String photo;
	
	// Constructors
	public President() {}
	
	public President(int termNumber, String firstName, String middleName, 
			String lastName, int startYear, int endYear, String party) {
//		System.out.println("In President constructor");
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
		this.photo = "PresImages/" + termNumber + ".jpg";
		this.displayName =  firstName + " " + middleName + " " + lastName; 
		
		this.displayInfo = startYear + "-" + endYear + " " + party; 
		
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
	
	public String getDisplayInfo() {
		return displayInfo;
	}
	public String getDisplayName(){
		return displayName;
	}
	public void setQuote(String quote){
//		System.out.println("in setQuote()");
		this.quote = quote;
	}
	public String getQuote() {
//		System.out.println("in getQuote()");
		return quote;
	}
	public String getPhoto(){
		return photo;
	}
	
	

	@Override
	public String toString() {
		return "President [termNumber=" + termNumber + ", \nfirstName=" + firstName + ", \nmiddleName=" + middleName
				+ ", \nlastName=" + lastName + ", \nstartYear=" + startYear + ", \nendYear=" + endYear + ", \nparty=" + party
				+ "\nquote=" + quote + "]";
	}
	
}
