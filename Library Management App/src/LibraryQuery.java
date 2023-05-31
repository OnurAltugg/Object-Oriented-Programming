import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LibraryQuery {
	
	public String mostCopiesBook(Book[] booksList) { // We calculated according to quantity.
		
		String bookName = "" ;
		int max = 0;
		for(int i = 0 ; i < booksList.length ; i++ ) {
			if(booksList[i].getQuantity() > max) {
				max = booksList[i].getQuantity();
				bookName = booksList[i].getTitle();
			}
		}
		return bookName;
		
	}
	
	public String fewestCopiesBook(Issue[][] issuesList,Book[] booksList) {
		
		String bookName = "" ;
		int min =1000;
		
		for(int i = 0 ; i < issuesList.length ; i++) {
			for(int j = 0 ; j < 30 ; j++) {
				if(issuesList[i][j] == null ) {
					continue;
				}
				for(int bookFinder = 0 ; bookFinder < booksList.length ; bookFinder++ ) {
					if(issuesList[i][j].getBook().equals(booksList[bookFinder].getId()) && booksList[bookFinder].getQuantity()<min) {
						min = booksList[bookFinder].getQuantity();
						bookName = booksList[bookFinder].getTitle();
						continue;
					}
				}
			}
		}
		
		return bookName;
	}
	
	public double highestPenalty(Issue[][] issuesList) {
		int max = 0;	
		for(int i = 0 ; i < issuesList.length ; i++) {
			for(int j = 0 ; j < 30 ; j++) {
				if(issuesList[i][j] == null) {
					continue;
				}
				long tempValue = calculateTimeDifference(issuesList[i][j].getIssueDate(),issuesList[i][j].getReturningDate());
				if(tempValue > max) {
					max = (int) tempValue;
				}
			}
		}
		return (double)(max-15)*(0.5);
	}
	
	public long calculateTimeDifference(String startDate , String endDate) {
		
		long timeDifference;
		String newStartDate = changeMonth(startDate);
		String newEndDate = changeMonth(endDate);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
		try {
			Date issueDate = simpleDateFormat.parse(newStartDate);
			Date returningDate = simpleDateFormat.parse(newEndDate);
		    timeDifference = returningDate.getTime() - issueDate.getTime();
		    return TimeUnit.DAYS.convert(timeDifference, TimeUnit.MILLISECONDS);
			
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return -1 ;
		
	}
	
	public String changeMonth(String date) {  // For SimpleDateFormat("dd-MM-yy");
		String[] dateArray = date.split("-");
		if(dateArray[1].equals("Jan")) {
			dateArray[1] = "01";
		}
		else if(dateArray[1].equals("Feb")) {
			dateArray[1] = "02";
		} 
		else if(dateArray[1].equals("Mar")) {
			dateArray[1] = "03";
		} 
		else if(dateArray[1].equals("Apr")) {
			dateArray[1] = "04";
		} 
		else if(dateArray[1].equals("May")) {
			dateArray[1] = "05";
		} 
		else if(dateArray[1].equals("Jun")) {
			dateArray[1] = "06";
		} 
		else if(dateArray[1].equals("Jul")) {
			dateArray[1] = "07";
		} 
		else if(dateArray[1].equals("Aug")) {
			dateArray[1] = "08";
		} 
		else if(dateArray[1].equals("Sep")) {
			dateArray[1] = "09";
		} 
		else if(dateArray[1].equals("Oct")) {
			dateArray[1] = "10";
		}
		else if(dateArray[1].equals("Nov")) {
			dateArray[1] = "11";
		}
		else if(dateArray[1].equals("Dec")) {
			dateArray[1] = "12";
		}
		return dateArray[0]+"-"+dateArray[1]+"-"+dateArray[2];
	}
	
	public String mostIssuedBook(Issue[][] issuesList,Book[] booksList ) {
		
		int loopCounter = 0 ;
		int idCounter = 0 ;
		String bookName = "" ;
		String bookId = "";
		int max = 0 ;
		int row = 0 ;
		int column = 0 ;
		
		while(loopCounter < 90) {

			for(int i = 0 ; i < issuesList.length ; i++) {
				for(int j = 0 ; j < 30 ; j++) {
					if(issuesList[i][j] == null || issuesList[row][column] == null) {
						continue;
					}
					else if(issuesList[i][j].getBook().equals(issuesList[row][column].getBook())) {
						idCounter++;
					}	
				}
			}
			if((idCounter > max)){
				bookId = issuesList[row][column].getBook();
				max = idCounter;
			}
			idCounter = 0;
			column++;
			if(column == 30) {
				column = 0;
				row++;
			}
			loopCounter++;
			
		}
		
		for(int i = 0 ; i < booksList.length ; i++) {
			if(bookId.equals(booksList[i].getId())) {
				bookName = booksList[i].getTitle();
			}
		}
		
		return bookName;
		
	}
	
	public String mostIssuedMember(Issue[][] issuesList, Member[] membersList) {
		
		int loopCounter = 0 ;
		int idCounter = 0 ;
		String memberName = "";
		int memberId = 0 ;
		int max = 0 ;
		int row = 0 ;
		int column = 0 ;
		
		while(loopCounter < 90) {

			for(int i = 0 ; i < issuesList.length ; i++) {
				for(int j = 0 ; j < 30 ; j++) {
					if(issuesList[i][j] == null || issuesList[row][column] == null) {
						continue;
					}
					else if(issuesList[i][j].getMember() == issuesList[row][column].getMember()) {
						idCounter++;
					}	
				}
			}
			if((idCounter > max)){
				memberId = issuesList[row][column].getMember();
				max = idCounter;
			}
			idCounter = 0;
			column++;
			if(column == 30) {
				column = 0;
				row++;
			}
			loopCounter++;
			
		}
		for(int i = 0 ; i < membersList.length ; i++) {
			if(memberId == membersList[i].getId()) {
				memberName = membersList[i].getName();
			}
		}
		
		return memberName;
		
	}
	
	public String leastIssuedMemberFromCsl(Issue[][] issuesList,Member[] membersList) {
		int min = 100 ;
		int idCounter = 0;
		String memberName = "";
		int memberId = 0 ;
		
		for(int i = 0 ; i < 17 ; i++) {
			for(int j = 0 ; j < 17 ; j++) {
				if(issuesList[2][i].getMember() == issuesList[2][j].getMember()) {
					idCounter++;
				}
			}
			if(idCounter<min) {
				min = idCounter ;
				memberId = issuesList[2][i].getMember();
			}
			idCounter = 0 ;
		}
		
		for(int i = 0 ; i < membersList.length ; i++) {
			if(memberId == membersList[i].getId()) {
				memberName = membersList[i].getName();
			}
		}
		
		return memberName;
        				
	}

}
