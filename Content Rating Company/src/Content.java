
public abstract class Content implements ICompany {
	
	private int arrivalDay;
	private String name ;
	
	public Content(int arrivalDay, String name) {
		this.arrivalDay = arrivalDay;
		this.name = name ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArrivalDay() {
		return arrivalDay;
	}

	public void setArrivalDay(int arrivalDay) {
		this.arrivalDay = arrivalDay;
	}

	public abstract double ratingCalculation(Critic critic);

		
	}
	
	
		
	
	
	
	
	
	


