import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class GameCritic extends Critic {
	
	private String situation = "works on";
	public int remainTime;
	
	public GameCritic(String name, String tag, double opinion) {
		super(name, tag, opinion);
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public int getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}
	
	public void review(ArrayList<String> gameRatingList, Queue<Critic> waitingGameCriticList, Iterator<Critic> iterator, Critic critic) {
		if(this.getContentTime() > this.getRemainTime()) {
    		this.setContentTime(this.getContentTime() - this.getRemainTime());
    		setChecked(true);
		}
		else {
			this.setRemainTime(this.getRemainTime() - this.getContentTime());
			this.setSituation("evaluated");
			System.out.println(this.toString());
			gameRatingList.add(this.toRating((float)getContentAverageRating()));
			this.setSituation("works on");
			setChecked(true);
			waitingGameCriticList.add(critic);
			iterator.remove();
		}
	}
	
	public String toRating(float rating) {
		return  "\t" + getContentName() + ", " + rating;
	}
	
	public String toString() {
		return super.toString() + getSituation() + " (" + getContentName() + ")";
	}

}
