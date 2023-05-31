import java.util.ArrayList;

public class VisaControlApplication {

	public static void main(String[] args) {
		
		ArrayList<String> applicantList = new ArrayList<String>();
		applicantList = FileIO.fileReader("HW2_ApplicantsInfo.csv");
		ArrayList<ApplicantInfo> applicantInfoList = new ArrayList<ApplicantInfo>();
		ArrayList<Passport> passportList = new ArrayList<Passport>();
		ArrayList<Photo> photoList = new ArrayList<Photo>();
		ArrayList<FinancialStatus> financialStatusList = new ArrayList<FinancialStatus>();
		ArrayList<Document> documentList = new ArrayList<Document>();
		
		for(String searcher : applicantList) {   //We separated objects with arraylist.

			if(searcher.charAt(0) == 'A') {
				
				String[] tempApplicantInfoArray = new String[3];
				tempApplicantInfoArray = searcher.split(",");
				applicantInfoList.add(new ApplicantInfo('A', tempApplicantInfoArray[1], tempApplicantInfoArray[2]));
			}
			
			else if (searcher.charAt(0) == 'S') {
				
				String[] tempPassportArray = new String[4];
				tempPassportArray = searcher.split(",");
				passportList.add(new Passport('S', tempPassportArray[1], tempPassportArray[2], tempPassportArray[3]));
			}
			
			else if (searcher.charAt(0) == 'P') {
				
				String[] tempPhotoArray = new String[4];
				tempPhotoArray = searcher.split(",");
				photoList.add(new Photo('P', tempPhotoArray[1], tempPhotoArray[2], tempPhotoArray[3]));
			}
			
			else if (searcher.charAt(0) == 'F') {
				
				String[] tempFinancialStatusArray = new String[4];
				tempFinancialStatusArray = searcher.split(",");
				financialStatusList.add(new FinancialStatus('F', tempFinancialStatusArray[1], Integer.parseInt(tempFinancialStatusArray[2]), Integer.parseInt(tempFinancialStatusArray[3])));
			}
			
			else if (searcher.charAt(0) == 'D') {
				
				String[] tempDocumentArray = new String[4];
				tempDocumentArray = searcher.split(",");
				if(tempDocumentArray.length == 3) {
					documentList.add(new Document('D', tempDocumentArray[1], tempDocumentArray[2]));
				}
				else {
					documentList.add(new Document('D', tempDocumentArray[1], tempDocumentArray[2], Integer.parseInt(tempDocumentArray[3])));
				}
				
			}
			
		}
		FileIO.selectionSort(applicantInfoList);
		int counter = 0;
		while(counter < applicantInfoList.size()) {
			System.out.print("Applicant ID: " + applicantInfoList.get(counter).getId() + ", " + "Name: "+applicantInfoList.get(counter).getName() +
					", " + "Visa Type: " + applicantInfoList.get(counter).typesOfApplication());
			
			Passport givenPassport = applicantInfoList.get(counter).givePassport(passportList);
			if(givenPassport == null) {
				System.out.println(", " + "Status: Rejected, Reason: Applicant does not have a passport");
				counter++;
				System.out.println(); //for design
				continue;
			}
			else {
				String checkPassport = givenPassport.checkPassport();
				if(!checkPassport.equals("Correct Passport")) {
					System.out.println(", " + "Status: Rejected, Reason: " + checkPassport);
					counter++;
					System.out.println();
					continue;
				}
			}
			Photo givenPhoto = applicantInfoList.get(counter).givePhoto(photoList);
			if(givenPhoto == null) {
				System.out.println(", " + "Status: Rejected, Reason: Applicant does not have a photo");
				counter++;
				System.out.println();
				continue;
			}
			else {
				String checkPhoto = givenPhoto.checkPhoto();
				if(!checkPhoto.equals("Correct Photo")) {
					System.out.println(", " + "Status: Rejected, Reason: " + checkPhoto);
					counter++;
					System.out.println();
					continue;
				}
			}
			FinancialStatus givenFinancialStatus = applicantInfoList.get(counter).giveFinancialStatus(financialStatusList); 
			if(givenFinancialStatus == null) {
				System.out.println(", " + "Status: Rejected, Reason: Applicant does not have a financial status report");
				counter++;
				System.out.println();
				continue;
			}
			else {
				String checkFinancialStatus = givenFinancialStatus.checkFinancialStatus(documentList);
				if(!checkFinancialStatus.equals("Correct Financial Status")) {
					System.out.println(", " + "Status: Rejected, Reason: " + checkFinancialStatus);
					counter++;
					System.out.println();
					continue;
				}
			}
			
			if(!Document.checkDocument(applicantInfoList.get(counter), documentList)) {
				System.out.println(", " + "Status: Rejected, Reason: Applicant does not have a letter of acceptance");
				counter++;
				System.out.println();
				continue;
			}
			
			String visaDuration = applicantInfoList.get(counter).visaDuration(documentList, financialStatusList, passportList);
			if(visaDuration.equals("No Visa")) {
				System.out.println(", " + "Status: Rejected, Reason: Applicant does not have a suitable visa duration");
				counter++;
				System.out.println();
				continue;
			}
			else {
				System.out.println(", " + "Status: Accepted, Visa Duration: " + visaDuration);
				counter++;
				System.out.println();
				continue;
			}
		}
		
	}
}
