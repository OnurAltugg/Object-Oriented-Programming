
public class Duration implements IDuration {
	
	private int day;
	private boolean sameDay = false;
	
	public Duration(int day) {
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		setSameDay(false);
		this.day = day;
	}
	
	public void setSameDay(boolean sameDay) {
		this.sameDay = sameDay;
	}

	public boolean isSameDay() {
		return sameDay;
	}

	public String toString() {
		setSameDay(true);
		return getDay() + ". day:" ;
	}
	
	public void changeDay() {
		setDay(getDay() + 1);
	}

}
