import java.util.ArrayList;

public class ApplicantInfo { //Passport,Photo,FinancialStatus,Document derived class from ApplicantInfo base class
	
	private char information;
	private String id ;
	private String name;
	
	public ApplicantInfo(char information, String id, String name) {

		this.information = information;
		this.id = id;
		this.name = name;
	}
	
	public ApplicantInfo(char information, String id) {

		this.information = information;
		this.id = id;
	}

	public char getInformation() {
		return information;
	}

	public void setInformation(char information) {
		this.information = information;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String  typesOfApplication() {
		if(id.substring(0, 2).equals("11")) {
			return "Tourist";
		}
		else if(id.substring(0, 2).equals("23")) {
			return "Worker";
		}
		else if(id.substring(0, 2).equals("25")) {
			return "Educational";
		}
		else {
			return "Immigrant";
		}
	}
	
    public ArrayList<String> learnDocumentTypes(ArrayList<Document>list) {
    	
    	ArrayList<String> typeList = new ArrayList<String>();
    	for(int i = 0 ; i < list.size() ; i++) {
    		if(list.get(i).getId().equals(this.id)) {
    			typeList.add(list.get(i).getDocumentType());
    		}
    	}
    	return typeList;
    }
    
    public Passport givePassport(ArrayList<Passport>list) {
    	
    	Passport givenPassport = null ;
    	for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).getId().equals(id)) {
				givenPassport = list.get(i);
			}
		}
    	return givenPassport;
    	
    }
    
    public Photo givePhoto(ArrayList<Photo>list) {
    	
    	Photo givenPhoto = null ;
    	for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).getId().equals(id)) {
				givenPhoto = list.get(i);
			}
		}
    	return givenPhoto;
    }
    
    public FinancialStatus giveFinancialStatus(ArrayList<FinancialStatus>list) {
    	
    	FinancialStatus givenFinancialStatus = null ;
    	for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).getId().equals(id)) {
				givenFinancialStatus = list.get(i);
			}
		}
    	return givenFinancialStatus;
    }
    
    public Document giveDocument(ArrayList<Document>list) {
    	
    	Document givenDocument = null ;
    	for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).getId().equals(id) && list.get(i).getDurationInMonths() != 0) { //only objects with a letter of acceptance are returned
				givenDocument = list.get(i);
			}
		}
    	return givenDocument;
    }
    
    public String visaDuration(ArrayList<Document>docList, ArrayList<FinancialStatus>financialStatusList,ArrayList<Passport>passportList) {
		
		FinancialStatus testFinancialStatus = this.giveFinancialStatus(financialStatusList) ;
		Passport testPassport = this.givePassport(passportList);
		Document testDocument = this.giveDocument(docList);
		ArrayList<String> docTypeList = this.learnDocumentTypes(docList);
		double durationConstant = 0.0;
		int visaDuration = 0;
		
		long expirationDate = testPassport.calculateTimeDifference(testPassport.getExpirationDate()) ;
		
		if(this.typesOfApplication().equals("Tourist")) {
			if(docTypeList.contains("IL")) {
				durationConstant = (double)((testFinancialStatus.getIncome() - 2000) * 6 + testFinancialStatus.getSavings()) / 6000 ;
			}
			else {
				durationConstant = (double)((testFinancialStatus.getIncome() - 2000) * 6 + testFinancialStatus.getSavings()) / 12000 ;
			}
			if(durationConstant >= 1 && durationConstant < 2 ) {
				visaDuration = 183; // we converted it to 6 months 183 days.
			}
			else if(durationConstant >= 2 && durationConstant < 4 ) {
				visaDuration = 365;
			}
			else {
				visaDuration = 365*5;
			}

			if(expirationDate < visaDuration) {
				if(visaDuration == 183) {
					return "No Visa";
				}
				else if(visaDuration == 365 ){
					if(expirationDate < 183) {
						return "No Visa";
					}
					else {
						return "6 months";
					}
				}
				else {
					if(expirationDate < 183 ) {
						return "No Visa";
					}
					else if(expirationDate < 365) {
						return "6 months";
					}
					else {
						return "1 years";
					}
				}
			}
			else {
				if(visaDuration == 183) {
					return "6 months";
				}
				else if(visaDuration == 365 ){
					return "1 years";
				}
				else {
					return "5 years";
				}
			}
			
		}
		
		else if(this.typesOfApplication().equals("Worker")) {
			double durationInMonth = (double)testDocument.getDurationInMonths() / 12; //in years
			if(expirationDate < 365) {
				return "No Visa";
			}
			else if(expirationDate >= 365 && expirationDate < 365*2) {
				return "1 years";
			}
			else if(expirationDate >= 365*2 && expirationDate < 365*5) {
				if(durationInMonth >= 2) {
					return "2 years";
				}
				else {
					return "1 years";
				}
			}
			else {
				if(durationInMonth >= 5) {
					return "5 years";
				}
				else if(durationInMonth >= 2 && durationInMonth < 5) {
					return "2 years";
				}
				else {
					return "1 years";
				}
				
			}
			
		}
		else if(this.typesOfApplication().equals("Educational")) {
			double durationInMonth = (double)testDocument.getDurationInMonths() / 12;
			if(expirationDate < 365) {
				return "No Visa";
			}
			else if(expirationDate >= 365 && expirationDate < 365*2) {
				return "1 years";
			}
			else if(expirationDate >= 365*2 && expirationDate < 365*4) {
				if(durationInMonth >= 2) {
					return "2 years";
				}
				else {
					return "1 years";
				}
			}
			else {
				if(durationInMonth >= 4) {
					return "4 years";
				}
				else if(durationInMonth >= 2 && durationInMonth < 4) {
					return "2 years";
				}
				else {
					return "1 years";
				}
				
			}
			
		}
		else {
			return "Permanent";
		}
	}
}
	 
	
	


