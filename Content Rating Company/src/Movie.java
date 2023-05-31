
public class Movie extends Content{
	
	private int year ; 
	private int duration;
	private double averageRating;
	
	public Movie(int arrivalDay, String name, int year, int duration, double averageRating) {
		
		super(arrivalDay, name);
		this.year = year;
		this.duration = duration;
		this.averageRating = averageRating;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public double ratingCalculation(Critic critic) {
		double rating = averageRating + ((duration - 150) * 0.01) - ((2021 - year ) * 0.01) + (critic.getOpinion());
		if(rating > 10.0) {
			return 10.0;
		}
		else {
			return rating;
		}
	}
		
	


}
