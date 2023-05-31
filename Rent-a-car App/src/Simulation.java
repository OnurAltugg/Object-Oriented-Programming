import java.util.ArrayList;

public class Simulation {
	
	public static void run() {
		
		ArrayList<IndividualCustomer<Object>> individualCustomerList = new ArrayList<IndividualCustomer<Object>>();
		ArrayList<CommercialCustomer> commercialCustomerList = new ArrayList<CommercialCustomer>();
		FileIO.fileReader("HW4_Rentals.csv", individualCustomerList, commercialCustomerList);
		
		Customer.createRentalPrice(individualCustomerList);
		Customer.createRentalPrice(commercialCustomerList);
		
		Customer.createRentalCode(individualCustomerList);
		Customer.createRentalCode(commercialCustomerList);
        
		System.out.println("Welcome!");
		System.out.println("Total number of cars rented: " + (individualCustomerList.size() + commercialCustomerList.size()));
		System.out.println("Total number of commercial rentals: " + commercialCustomerList.size());
		System.out.println("Total number of commercial rental-month: " + CommercialCustomer.getTotalMonths());
		System.out.println("Total number of individual rentals: " + individualCustomerList.size());
		System.out.println("Total number of individual rental-day: " + IndividualCustomer.getTotalDays());
		System.out.println("Total number of rentals of individual non-member customers: " + IndividualCustomer.countCustomers(individualCustomerList, false));
		System.out.println("Total number of rentals of individual member customers: " + IndividualCustomer.countCustomers(individualCustomerList, true));
		System.out.println("Total number of rentals of silver commercial customers: " + CommercialCustomer.countCustomers(commercialCustomerList, "Silver"));
		System.out.println("Total number of rentals of gold commercial customers: " + CommercialCustomer.countCustomers(commercialCustomerList, "Gold"));
		System.out.println("Total number of rentals of platinum commercial customers: " + CommercialCustomer.countCustomers(commercialCustomerList, "Platinum"));
		System.out.println();
		
		int no = 1;
		System.out.println("Individual Rentals:");
		System.out.println("-------------------");
		System.out.printf("%1s %15s %15s %14s %19s %16s %18s %15s", "No", " Rental Code", " Customer ID", "isMember", "Number of Days", "Car Model", 
				 "Model Year", "Rental Price\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		for(IndividualCustomer<Object> customer : individualCustomerList) {
			customer.showInformation(no);
			no++;
		}
		
		
		System.out.println();
		no = 1;
		System.out.println("Commercial Rentals:");
		System.out.println("-------------------");
		System.out.printf("%1s %14s %15s %16s %18s %17s %17s %15s", "No", " Rental Code", " Customer ID", " Customer Type", "Number of Months", 
				"Car Model", "Model Year", "Rental Price\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		for(CommercialCustomer customer : commercialCustomerList) {
			customer.showInformation(no);
			no++;
		}
	}

}
