
public class StoryGame extends Content {
	
	private int storyDuration;
	private int averageRating;
	
    public StoryGame(int arrivalDay, String name, int storyDuration, int averageRating) {
		
		super(arrivalDay, name);
		this.storyDuration = storyDuration;
		this.averageRating = averageRating;
	}

	public int getStoryDuration() {
		return storyDuration;
	}

	public void setStoryDuration(int storyDuration) {
		this.storyDuration = storyDuration;
	}

	public int getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}

	public double ratingCalculation(Critic critic) {
		double rating = averageRating + (storyDuration * 0.25) + (critic.getOpinion());
		if(rating > 100.0) {
			return 100.0;
		}
		else {
			return rating;
		}
	}
	
	


}
