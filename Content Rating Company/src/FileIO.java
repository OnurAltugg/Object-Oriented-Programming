import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	
    public static ArrayList<Content> fileReader(String fileName){
		
		ArrayList<String> tempFileList = new ArrayList<String>();
		ArrayList<Content> fileList = new ArrayList<Content>();
		try(Scanner scanner = new Scanner(new FileReader(fileName))){
			while(scanner.hasNextLine()) {
				tempFileList.add(scanner.nextLine());
			}
	    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String searcher : tempFileList) {
			
			if(searcher.length() == 0) {
				continue;
			}
			String[] movieArray = new String[6];
			String[] gameArray = new String[5];
			
			if(searcher.charAt(2) == '0') {
				movieArray = searcher.split(",");
				fileList.add(new Movie(Integer.parseInt(movieArray[0]), movieArray[2], Integer.parseInt(movieArray[3]), Integer.parseInt(movieArray[4]), Double.parseDouble(movieArray[5])));
			}
			else if(searcher.charAt(2) == '1') {
				gameArray = searcher.split(",");
				fileList.add(new IndefiniteGame(Integer.parseInt(gameArray[0]), gameArray[2], Integer.parseInt(gameArray[3]), Integer.parseInt(gameArray[4])));
			}
			else if(searcher.charAt(2) == '2') {
				gameArray = searcher.split(",");
				fileList.add(new StoryGame(Integer.parseInt(gameArray[0]), gameArray[2], Integer.parseInt(gameArray[3]), Integer.parseInt(gameArray[4])));
			}
			else if(searcher.charAt(2) == '3') {
				gameArray = searcher.split(",");
				fileList.add(new CasualGame(Integer.parseInt(gameArray[0]), gameArray[2], Integer.parseInt(gameArray[3]), Integer.parseInt(gameArray[4])));
			}
			
		}
		
		return fileList;
		
	}

}


