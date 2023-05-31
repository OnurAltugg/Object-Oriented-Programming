import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public interface ICritic {
	
	abstract String toRating(float rating); //adjusts calculated ratings for output
	
	abstract void review(ArrayList<String> ratingList, Queue<Critic> waitingCriticList, Iterator<Critic> iterator, Critic critic);

}
