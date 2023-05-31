import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	
	public static ArrayList<String> fileReader(String fileName){
		
		ArrayList<String> fileList = new ArrayList<String>();
		try(Scanner scanner = new Scanner(new FileReader(fileName))){
			while(scanner.hasNextLine()) {
				fileList.add(scanner.nextLine());
			}
	    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileList;
		
	}
	
    public static void selectionSort(ArrayList<ApplicantInfo>list) { // for ID sort
		
		for (int i = 0; i < list.size() - 1; i++) {
			int index = i ;
			for (int j = i + 1; j < list.size(); j++) {
				if((Integer.parseInt(list.get(j).getId()) < Integer.parseInt(list.get(index).getId()))){
					index = j; 
				}
			}
			ApplicantInfo haveSmallerId = list.get(index);
			list.set(index, list.get(i));
			list.set(i, haveSmallerId);
		}
	}

}
