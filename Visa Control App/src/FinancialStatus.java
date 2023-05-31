import java.util.ArrayList;

public class FinancialStatus extends ApplicantInfo {
	
	private int income;
	private int savings;

	public FinancialStatus(char information, String id, int income, int savings) {
		
		super(information, id);
		this.income = income;
		this.savings = savings;
		
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getSavings() {
		return savings;
	}

	public void setSavings(int savings) {
		this.savings = savings;
	}

	public String checkFinancialStatus(ArrayList<Document>docList) {
		
		ArrayList<String> docTypeList = this.learnDocumentTypes(docList);
		
		if(this.typesOfApplication().equals("Tourist")) {
			if(!docTypeList.contains("IL")) {
				if(!((income >= 2000 && income <= 3000 && savings >= 12000) || (income >= 3000 && income <= 4000 && savings >= 6000) || 
						(income >= 4000))){
					return "Applicant does not have a stable financial status";		
						}
			}
			else {
				if(docTypeList.contains("IL")) {
					if(!((income >= 1000 && income <= 1500 && savings >= 6000) || (income >= 1500 && income <= 2000 && savings >= 3000) || 
							(income >= 2000))){
						return "Applicant does not have a stable financial status";		
							}
				}
			}
			
		}
		else if(this.typesOfApplication().equals("Worker")) {
			if(savings < 2000) {
				return "Applicant does not have a stable financial status";
			}
		}
        else if(this.typesOfApplication().equals("Educational")) {
        	if(!docTypeList.contains("IL")) {
				if(!((income >= 1000 && income <= 2000 && savings >= 6000) || (income >= 2000 && income <= 3000 && savings >= 3000) || 
						(income >= 3000))){
					return "Applicant does not have a stable financial status";		
						}
			}
        	else {
        		if(docTypeList.contains("IL")) {
					if(!((income >= 500 && income <= 1000 && savings >= 3000) || (income >= 1000 && income <= 1500 && savings >= 1500) || 
							(income >= 1500))){
						return "Applicant does not have a stable financial status";		
							}
				}
        	}
			
		}
        else{
        	if(docTypeList.contains("GC") && docTypeList.contains("IL")) {
        		if(savings < 2000) {
        			return "Applicant does not have a stable financial status";
        		}
        	}
        	else if(docTypeList.contains("GC") && !docTypeList.contains("IL")){
        		if(savings < 4000) {
        			return "Applicant does not have a stable financial status";
        		}
        	}
        	else if(!docTypeList.contains("GC") && docTypeList.contains("IL")){
        		if(savings < 25000) {
        			return "Applicant does not have a stable financial status";
        		}
        	}
        	else {
        		if(savings < 50000) {
        			return "Applicant does not have a stable financial status";
        		}
        	}
			
		}
		return "Correct Financial Status";
		
	}

}
