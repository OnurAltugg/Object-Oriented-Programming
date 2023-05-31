import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Simulation {
	
	public static void printSimulation(Queue<MovieCritic> movieCriticList, Queue<GameCritic> gameCriticList, Stack<Content> movieList, Stack<Content> gameList, ArrayList<String> movieRatingList,
    		ArrayList<String> gameRatingList, Duration duration) {
		
		ArrayList<Critic> worksOnCriticList = new ArrayList<Critic>(); //critics with assignments
		ArrayList<Critic> tempWorksOnGameCriticList = new ArrayList<Critic>();//for correct output
		Queue<Critic> waitingMovieCriticList = new LinkedList<>(); //critics without assignments will be on their own lists at the end of the day
		Queue<Critic> waitingGameCriticList = new LinkedList<>();
		while(duration.getDay() < 6) {
			
			if(!duration.isSameDay()) {
				System.out.println(duration.toString());
				Iterator<MovieCritic> movieCriticIterator = movieCriticList.iterator();
    			Iterator<GameCritic> gameCriticIterator = gameCriticList.iterator();
    			Iterator<Critic> worksOnCriticIterator = worksOnCriticList.iterator();
                while(movieCriticIterator.hasNext()) {
                	MovieCritic critic = movieCriticIterator.next();
                	critic.setChecked(false);
                }
                while(gameCriticIterator.hasNext()) {
                	GameCritic critic = gameCriticIterator.next();
                	critic.setChecked(false);
                	critic.setRemainTime(8 * 60);
                }
                while(worksOnCriticIterator.hasNext()) { //critics who can't get their assignment done in a day
                	GameCritic critic = (GameCritic) worksOnCriticIterator.next();
                	critic.setChecked(false);
                	critic.setRemainTime(8 * 60);
                }
			}
			while(movieCriticList.size() != 0) { //assignments
				
				if(movieList.size() == 0) {
            		movieCriticList.remove();
    			}
				else if(movieList.peek().getArrivalDay() > duration.getDay()) {
					waitingMovieCriticList.add(movieCriticList.peek());
            		movieCriticList.remove();
            	}
				else {
            		Movie movie = (Movie) movieList.peek();
    				movieList.pop();
    				movieCriticList.peek().setContentTime(movie.getDuration());
    				movieCriticList.peek().setContentName(movie.getName());
    				movieCriticList.peek().setContentAverageRating(movie.ratingCalculation(movieCriticList.peek()));
    				movieCriticList.peek().setContentYear(movie.getYear());
    				worksOnCriticList.add(movieCriticList.peek());
    				movieCriticList.remove();
            	}
			}		
			while(gameCriticList.size() != 0) { ////assignments
				
				if(gameList.size() == 0) {
					gameCriticList.remove();
    			}
				else if(gameList.peek().getArrivalDay() > duration.getDay()) {
					waitingGameCriticList.add(gameCriticList.peek());
            		gameCriticList.remove();
            	}
				else if(gameList.peek() instanceof IndefiniteGame) {
					IndefiniteGame indefiniteGame = (IndefiniteGame) gameList.peek();
					gameCriticList.peek().setContentTime(4 * 60);
					gameCriticList.peek().setContentName(indefiniteGame.getName());
					gameCriticList.peek().setContentAverageRating(indefiniteGame.ratingCalculation(gameCriticList.peek()));
					gameList.pop();
    				worksOnCriticList.add(gameCriticList.peek());
    				tempWorksOnGameCriticList.add(gameCriticList.peek());
    				gameCriticList.remove();
				}
				else if(gameList.peek() instanceof StoryGame) {
					StoryGame storyGame = (StoryGame) gameList.peek();
					gameCriticList.peek().setContentTime(storyGame.getStoryDuration() * 60);
					gameCriticList.peek().setContentName(storyGame.getName());
					gameCriticList.peek().setContentAverageRating(storyGame.ratingCalculation(gameCriticList.peek()));
					gameList.pop();
    				worksOnCriticList.add(gameCriticList.peek());
    				tempWorksOnGameCriticList.add(gameCriticList.peek());
    				gameCriticList.remove();
				}
				else {
					CasualGame casualGame = (CasualGame) gameList.peek();
					gameCriticList.peek().setContentTime(casualGame.getMatchDuration() * 3 * 60);
					gameCriticList.peek().setContentName(casualGame.getName());
					gameCriticList.peek().setContentAverageRating(casualGame.ratingCalculation(gameCriticList.peek()));
					gameList.pop();
    				worksOnCriticList.add(gameCriticList.peek());
    				tempWorksOnGameCriticList.add(gameCriticList.peek());
    				gameCriticList.remove();
				}
			}
			Sort.sortTime(worksOnCriticList);
			Iterator<Critic> iterator = worksOnCriticList.iterator();
            while(iterator.hasNext()) {
            	
            	Critic critic = iterator.next();
            	if(critic.getTag().equals("movie") && !critic.isChecked()) {
            		critic.review(movieRatingList, waitingMovieCriticList, iterator, critic);
            	}
            	else {
            		for(int i=0 ; i < tempWorksOnGameCriticList.size() ; i++) {
            			System.out.println(tempWorksOnGameCriticList.get(i).toString());
            		}
            		tempWorksOnGameCriticList.clear();
            		break;
            	}
            }
            Iterator<Critic> newIterator = worksOnCriticList.iterator();
            while(newIterator.hasNext()) {
            	
            	Critic critic = newIterator.next();
            	if(critic.getTag().equals("movie") && !critic.isChecked()) {
            		critic.review(movieRatingList, waitingMovieCriticList, newIterator, critic);
            	}
            	else if(!critic.isChecked()) {
            		critic.review(gameRatingList, waitingGameCriticList, newIterator, critic);
            	}
            }
            if(((GameCritic) waitingGameCriticList.peek()).getRemainTime() > 0 && gameList.size() != 0 && 
            		gameList.peek().getArrivalDay() <= duration.getDay()) { //game critic check that does not expire if game is available
            	waitingGameCriticList.peek().setChecked(false);
            	gameCriticList.add((GameCritic) waitingGameCriticList.remove());
            }
            else {
            	duration.changeDay();
            	while(waitingGameCriticList.size()!=0) {
            		gameCriticList.add((GameCritic) waitingGameCriticList.remove());
            	}
            	while(waitingMovieCriticList.size()!=0) {
            		movieCriticList.add((MovieCritic) waitingMovieCriticList.remove());
            	}
            }
		}
		System.out.println("Ratings:");
        Critic.printRating(movieRatingList);
        System.out.println("\t--------------------------------");
        Critic.printRating(gameRatingList);
	}
}
