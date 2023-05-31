import java.util.ArrayList;
import java.util.Stack;

public class Sort {
	
	 public static void arrivalDaySort(ArrayList<Content>list, Stack<Content> movieList, Stack<Content> gameList){
	    	
    	 for (int i = 0; i < list.size() - 1; i++) {
			int index = i ;
			for (int j = i + 1; j < list.size(); j++) {
				if(list.get(index).getArrivalDay() < list.get(j).getArrivalDay()) {
					index = j; 
					
				}
			}
			Content haveBiggerArrivalDay = list.get(index);
			list.set(index, list.get(i));
			list.set(i, haveBiggerArrivalDay);
    	 }	
    	
    	for(int i = 0 ; i < list.size() ; i++) {
    		if(list.get(i) instanceof Movie) {
    			movieList.push(list.get(i));
    		}
    		else {
    			gameList.push(list.get(i));
    		}

    	}

    }
	 
	public static void sortTime(ArrayList<Critic> list) {
			for (int i = 0; i < list.size() - 1; i++) {
				int index = i ;
				for (int j = i + 1; j < list.size(); j++) {
					if(list.get(j).getContentTime() < list.get(index).getContentTime()){
						index = j; 
					}
				}
				Critic haveSmallerTime = list.get(index);
				list.set(index, list.get(i));
				list.set(i, haveSmallerTime);
			}
	}

}
