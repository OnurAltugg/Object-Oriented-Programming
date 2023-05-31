import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ContentRatingCompanyApp {

	public static void main(String[] args) {
		
		Stack<Content> movieList= new Stack<Content>();
		Stack<Content> gameList= new Stack<Content>();
		ArrayList<Content> contentList = new ArrayList<Content>();
		contentList = FileIO.fileReader("contents.csv");
		Sort.arrivalDaySort(contentList, movieList, gameList); //movieList and gameList filled here
		
		Queue<MovieCritic> movieCriticList = new LinkedList<>();
		Queue<GameCritic> gameCriticList = new LinkedList<>();
		movieCriticList.add(new MovieCritic("1. movie critic ", "movie", 0.1));
		movieCriticList.add(new MovieCritic("2. movie critic ", "movie", -0.2));
		movieCriticList.add(new MovieCritic("3. movie critic ", "movie",  0.3));
		gameCriticList.add(new GameCritic("1. game critic ", "game", 5));
		gameCriticList.add(new GameCritic("2. game critic ", "game", 9));
		gameCriticList.add(new GameCritic("3. game critic ", "game", -3));
		gameCriticList.add(new GameCritic("4. game critic ", "game", 2));
		gameCriticList.add(new GameCritic("5. game critic ", "game", -7));
		
		ArrayList<String> movieRatingList = new ArrayList<String>();
		ArrayList<String> gameRatingList = new ArrayList<String>();
		Duration duration = new Duration(1); 
		Simulation.printSimulation(movieCriticList, gameCriticList, movieList, gameList, movieRatingList, gameRatingList, duration);

	}

}
