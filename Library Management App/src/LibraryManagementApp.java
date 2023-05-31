import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LibraryManagementApp {
	
	public static String[] fileReader(String fileName , int readFileColumn  ) {
		
		String[] item = new String[readFileColumn];
		try(Scanner scanner = new Scanner(new FileReader(fileName))){
			int i = 0;
			while(scanner.hasNextLine()) {
				item[i] = scanner.nextLine();
				i++;
			}
	    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return item ;
		
	}

	public static void main(String[] args) {
		
		String[] tempMembersArray = fileReader("Members.csv",6);
		
		String[] membersArray1 = tempMembersArray[1].split(",");
		String[] membersArray2 = tempMembersArray[2].split(",");
		String[] membersArray3 = tempMembersArray[3].split(",");
		String[] membersArray4 = tempMembersArray[4].split(",");
		String[] membersArray5 = tempMembersArray[5].split(",");
		
		Member admin = new Member(Integer.parseInt(membersArray1[0]),membersArray1[1],membersArray1[2]);
		Member tugkan = new Member(Integer.parseInt(membersArray2[0]),membersArray2[1],membersArray2[2]);
		Member dilek = new Member(Integer.parseInt(membersArray3[0]),membersArray3[1],membersArray3[2]);
		Member huseyin = new Member(Integer.parseInt(membersArray4[0]),membersArray4[1],membersArray4[2]);
		Member serhat = new Member(Integer.parseInt(membersArray5[0]),membersArray5[1],membersArray5[2]);
		Member[] membersList = {admin,tugkan,dilek,huseyin,serhat};
		
		Library library = new Library(43);
		String[] tempBooksL1Array = fileReader("L1_Books.csv",20);
		int count = 0 ;
		
		while(count < 20) {
			
			String[] booksL1Array = tempBooksL1Array[count].split(",");
			library.add(new Book(booksL1Array[0],booksL1Array[1],booksL1Array[2],booksL1Array[3],Integer.parseInt(booksL1Array[4]),booksL1Array[5],Integer.parseInt(booksL1Array[6])));
			count++;
		}
		
		String[] tempBooksL2Array = fileReader("L2_Books.csv",10);
		count = 0 ;
		
		while(count < 10) {
			
			String[] booksL2Array = tempBooksL2Array[count].split(",");
			library.add(new Book(booksL2Array[0],booksL2Array[1],booksL2Array[2],booksL2Array[3],Integer.parseInt(booksL2Array[4]),booksL2Array[5],Integer.parseInt(booksL2Array[6])));
			count++;
		}
		
		String[] tempBooksL3Array = fileReader("L3_Books.csv",13);
		count = 0;
		
		while(count < 13) {
			
			String[] booksL3Array = tempBooksL3Array[count].split(",");
			library.add(new Book(booksL3Array[0],booksL3Array[1],booksL3Array[2],booksL3Array[3],Integer.parseInt(booksL3Array[4]),booksL3Array[5],Integer.parseInt(booksL3Array[6])));
			count++;
		}
		
		LibraryManagement libraryManagement = new LibraryManagement(3,30);
		String[] tempIssuesL1Array = fileReader("L1_Issues.csv",30);
		count = 0 ;
		
		while(count < 30) {
			
			String[] issuesL1Array = tempIssuesL1Array[count].split(",");
			libraryManagement.add(new Issue(Integer.parseInt(issuesL1Array[0]),Integer.parseInt(issuesL1Array[1]),issuesL1Array[2],issuesL1Array[3],issuesL1Array[4]));
			count++;
		}
		
		libraryManagement.increaseCurrentRow();
		String[] tempIssuesL2Array = fileReader("L2_Issues.csv",13);
		count = 0 ;
		
		while(count < 13) {
			
			String[] issuesL2Array = tempIssuesL2Array[count].split(",");
			libraryManagement.add(new Issue(Integer.parseInt(issuesL2Array[0]),Integer.parseInt(issuesL2Array[1]),issuesL2Array[2],issuesL2Array[3],issuesL2Array[4]));
			count++;
		}
		
		libraryManagement.increaseCurrentRow();
		String[] tempIssuesL3Array = fileReader("L3_Issues.csv",17);
		count = 0 ;
		
		while(count < 17) {
			
			String[] issuesL3Array = tempIssuesL3Array[count].split(",");
			libraryManagement.add(new Issue(Integer.parseInt(issuesL3Array[0]),Integer.parseInt(issuesL3Array[1]),issuesL3Array[2],issuesL3Array[3],issuesL3Array[4]));
			count++;
		}
		
		
		LibraryQuery libraryQuery = new LibraryQuery();
		
		System.out.println("1) " + libraryQuery.mostIssuedBook(libraryManagement.getIssuesList() , library.getBooksList()));
		System.out.println("2) " + libraryQuery.mostIssuedMember(libraryManagement.getIssuesList(), membersList));
		System.out.println("3) " + libraryQuery.highestPenalty(libraryManagement.getIssuesList()) + " TL");
		System.out.println("4) " + libraryQuery.mostCopiesBook(library.getBooksList()));
		System.out.println("5) " + libraryQuery.fewestCopiesBook(libraryManagement.getIssuesList() ,library.getBooksList()));
		System.out.println("6) " + libraryQuery.leastIssuedMemberFromCsl(libraryManagement.getIssuesList(), membersList) );
		
		
		
		
		
		

		
			
		
		 

	 }
}