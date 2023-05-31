import java.util.ArrayList;

public class Document extends ApplicantInfo{
	
	private String documentType;
	private  int durationInMonths;

	public Document(char information, String id, String documentType, int durationInMonths) {
		
		super(information, id);
		this.documentType = documentType;
		this.durationInMonths = durationInMonths;
		
	}
	
    public Document(char information, String id, String documentType) {
		
		super(information, id);
		this.documentType = documentType;
		
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
    
	public static boolean checkDocument(ApplicantInfo applicantInfo, ArrayList<Document>list) {
		//Since not every object is in the document, we preferred static.
		if(applicantInfo.typesOfApplication().equals("Tourist") || applicantInfo.typesOfApplication().equals("Immigrant")) {
			return true;
		}
		ArrayList<String> docTypeList = applicantInfo.learnDocumentTypes(list);
		if(docTypeList.contains("LA")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
    
	
	
	
	
	
	

}
