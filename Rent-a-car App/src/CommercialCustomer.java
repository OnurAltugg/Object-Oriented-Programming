import java.util.ArrayList;
import java.util.Iterator;

public class CommercialCustomer extends Customer {
	
	private String customerID;
	private String memberType;
	private static int totalMonths;
	
	public CommercialCustomer(String customerID, int time, Car car) {
		super(time, car);
		this.customerID = customerID;
		if(this.customerID.startsWith("S")) {
			setMemberType("Silver");
		}
		else if(this.customerID.startsWith("G")) {
			setMemberType("Gold");
		}
		else {
			setMemberType("Platinum");
		}
		CommercialCustomer.setTotalMonths(CommercialCustomer.getTotalMonths() + this.getTime());
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public static int getTotalMonths() {
		return totalMonths;
	}

	public static void setTotalMonths(int totalMonths) {
		CommercialCustomer.totalMonths = totalMonths;
	}

	public float calculateTotalPrice() {
		
		double discount = 0.0;
		if(memberType.equals("Silver")) {
			discount = 0.2;
		}
		else if(memberType.equals("Gold")) {
			discount = 0.25;
		}
		else {
			discount = 0.3;
		}
		return (float) (getCar().calculateDailyPrice() * 30 * getTime() * (1 - discount));
	}
	
	public static int countCustomers(ArrayList<CommercialCustomer> customerList, String tag) {
		
		int count = 0 ;
		Iterator<CommercialCustomer> iterator = customerList.iterator();
		while(iterator.hasNext()) {
			 CommercialCustomer customer = iterator.next();
			 if(customer.getMemberType().equals(tag)) {
				 count++;
			 }
        }
		return count;
	}

	public void showInformation(int no) {
		
		System.out.format("%1s %13s %15s %14s %14s %27s %12s %17s",String.valueOf(no), getCar().getRentalCode(), getCustomerID(), getMemberType(), getTime(), getCar().getCarModel(), 
				getCar().getCarModelYear(), getCar().getRentalPrice());
		System.out.println();
	}
	
	

}
