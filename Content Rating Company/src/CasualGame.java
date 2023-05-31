
public class CasualGame extends Content {
	
	private int matchDuration;
	private int averageRating;
	
    public CasualGame(int arrivalDay, String name, int matchDuration, int averageRating) {
		
		super(arrivalDay, name);
		this.matchDuration = matchDuration;
		this.averageRating = averageRating;
	}

	public int getMatchDuration() {
		return matchDuration;
	}

	public void setMatchDuration(int matchDuration) {
		this.matchDuration = matchDuration;
	}

	public int getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}

	public double ratingCalculation(Critic critic) {
		double rating = averageRating + ((matchDuration - 3) * 3) + (critic.getOpinion());
		if(rating > 100.0) {
			return 100.0;
		}
		else {
			return rating;
		}
	}
	
	


}
