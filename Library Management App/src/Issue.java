
public class Issue {
	
	private int id ;
	private int member ;
	private String book ;
	private String issueDate;
	private String returningDate;
	
	public Issue(int id, int member, String book, String issueDate, String returningDate) {
		super();
		this.id = id;
		this.member = member;
		this.book = book;
		this.issueDate = issueDate;
		this.returningDate = returningDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(String returningDate) {
		this.returningDate = returningDate;
	}
	
	

}
