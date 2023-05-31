
public class IndefiniteGame extends Content {
	 
	private int minimumEvaluationTime;
	private int averageRating;
	
	public IndefiniteGame(int arrivalDay, String name, int minimumEvaluationTime, int averageRating) {
		
		super(arrivalDay, name);
		this.minimumEvaluationTime = minimumEvaluationTime;
		this.averageRating = averageRating;
	}

	public int getMinimumEvaluationTime() {
		return minimumEvaluationTime;
	}

	public void setMinimumEvaluationTime(int minimumEvaluationTime) {
		this.minimumEvaluationTime = minimumEvaluationTime;
	}

	public int getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}

	public double ratingCalculation(Critic critic) {
		double rating = averageRating + ((10 - minimumEvaluationTime) * 0.25) + (critic.getOpinion());
		if(rating > 100.0) {
			return 100.0;
		}
		else {
			return rating;
		}
	}
	
	


}
