
public class LibraryManagement {
	
	private final Issue[][] issuesList ;
	private int currentRow ;
	private int numberOfEntries; // currentColumn

	public LibraryManagement(int rowSize , int columnSize) {
		
		Issue[][] tempIssuesList = new Issue[rowSize][columnSize];
		issuesList = tempIssuesList;
		this.numberOfEntries = 0 ;
		this.currentRow = 0;
	}

	public Issue[][] getIssuesList() {
		return issuesList;
	}
	
	public void add(Issue newIssue) {
		issuesList[currentRow][numberOfEntries] = newIssue;
		numberOfEntries++;
	}
	
	public void increaseCurrentRow() {
		currentRow++;
		numberOfEntries = 0 ;
	}
	

}
