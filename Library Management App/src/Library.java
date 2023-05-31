
public class Library {
	
	private final Book[] booksList;
	private int numberOfEntries ;
	
	public Library(int size) {
		
		Book[] tempBooksList = new Book[size];
		booksList = tempBooksList;
		this.numberOfEntries = 0 ;
		
	}

	public int getNumberOfEntries() {
		return numberOfEntries;
	}

	public void setNumberOfEntries(int numberOfEntries) {
		this.numberOfEntries = numberOfEntries;
	}

	public Book[] getBooksList() {
		return booksList;
	}
	
	public void add(Book newBook) {
		booksList[numberOfEntries] = newBook;
		numberOfEntries++;
	}

}
