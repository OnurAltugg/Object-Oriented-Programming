import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class MovieCritic extends Critic {
	
	private int contentYear;
	private final String situation = "evaluated";
	
	public MovieCritic(String name, String tag, double opinion) {
		super(name, tag, opinion);
	}

	public int getContentYear() {
		return contentYear;
	}

	public void setContentYear(int contentYear) {
		this.contentYear = contentYear;
	}

	public String getSituation() {
		return situation;
	}
	
	public void review(ArrayList<String> movieRatingList, Queue<Critic> waitingMovieCriticList, Iterator<Critic> iterator, Critic critic) {
		System.out.println(this.toString());
		movieRatingList.add(this.toRating((float)getContentAverageRating()));
		setChecked(true);
		waitingMovieCriticList.add(critic);
		iterator.remove();
	}
	
	public String toRating(float rating) {
		return "\t" + getContentName() + " (" + getContentYear() + ")" + ", " + rating;
	}
	
	public String toString() {
		return super.toString() + getSituation() + " (" + getContentName() + ")";
	}

	
	

}
