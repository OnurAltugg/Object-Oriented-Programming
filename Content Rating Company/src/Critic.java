import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;

public abstract class Critic implements ICritic {
	
	private String name;
	private String tag;
	private double opinion;
	private int contentTime; 
	private String contentName;
	private double contentAverageRating;
    public boolean checked ; 
	
	public Critic(String name, String tag, double opinion) {
		this.name = name;
		this.tag = tag;
		this.opinion = opinion;
	}

	public double getOpinion() {
		return opinion;
	}

	public void setOpinion(double opinion) {
		this.opinion = opinion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public double getContentAverageRating() {
		return contentAverageRating;
	}

	public void setContentAverageRating(double contentAverageRating) {
		this.contentAverageRating = contentAverageRating;
	}
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public int getContentTime() {
		return contentTime;
	}

	public void setContentTime(int contentTime) {
		this.contentTime = contentTime;
	}

	public abstract String toRating(float rating);
	
	public abstract void review(ArrayList<String> ratingList, Queue<Critic> waitingCriticList, Iterator<Critic> iterator, Critic critic);
	
	public String toString() { //information during the day
		return "\t" + getName();
	}
	
	public static void printRating(ArrayList<String> list) {
		Collections.sort(list);
		for(String rating : list) {
			System.out.println(rating);
		}
	}

}
