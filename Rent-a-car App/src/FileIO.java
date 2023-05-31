import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	
	 public static void fileReader(String fileName, ArrayList<IndividualCustomer<Object>> individualCustomerList, ArrayList<CommercialCustomer> commercialCustomerList){
			
			ArrayList<String>fileList = new ArrayList<String>();
			try(Scanner scanner = new Scanner(new FileReader(fileName))){
				while(scanner.hasNextLine()) {
					fileList.add(scanner.nextLine());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			for(String searcher : fileList) {
				try {
					if(searcher.length() == 0) {
						continue;
					}
					String[] customerArray = new String[6];
					customerArray = searcher.split(",");
					
					if(customerArray[0].equals("Individual")) {
						if(customerArray[1].length() == 12) {
							individualCustomerList.add(new IndividualCustomer<Object>(customerArray[1], Integer.parseInt(customerArray[2]), new Car(customerArray[3], 
									Integer.parseInt(customerArray[4]), Double.parseDouble(customerArray[5]))));
						}
						else if(customerArray[1].length() == 11) {
							for(int i = 0 ; i < customerArray[1].length() ; i++) {
								if(!Character.isDigit(customerArray[1].charAt(i))) {
									throw new InvalidIDException(customerArray[1], "individual");
								}
							}
							individualCustomerList.add(new IndividualCustomer<Object>(Long.parseLong(customerArray[1]), Integer.parseInt(customerArray[2]), new Car(customerArray[3], 
									Integer.parseInt(customerArray[4]), Double.parseDouble(customerArray[5]))));
						}
						else {
							throw new InvalidIDException(customerArray[1], "individual");
						}
					}
					else {
						if(customerArray[1].length() == 8 && (customerArray[1].startsWith("S") || customerArray[1].startsWith("G") || customerArray[1].startsWith("P"))) {
							commercialCustomerList.add(new CommercialCustomer(customerArray[1], Integer.parseInt(customerArray[2]), new Car(customerArray[3], 
									Integer.parseInt(customerArray[4]), Double.parseDouble(customerArray[5]))));
						}
						else {
							throw new InvalidIDException(customerArray[1], "commercial");
						}
					}
				}
				catch(InvalidIDException e) {
					System.out.println(e.getMessage());
				}
			}
	 }
}
