import java.util.ArrayList;
import java.util.Iterator;

public class IndividualCustomer<T> extends Customer {
	
	private T customerID;
	private boolean isMember;
	private static int totalDays;
	
	public IndividualCustomer(T customerID, int time, Car car) {
		super(time, car);
		this.customerID = customerID;
		if(String.valueOf(this.customerID).length() == 12){
			setMember(true);
		}
		else {
			setMember(false);
		}
		IndividualCustomer.setTotalDays(IndividualCustomer.getTotalDays() + getTime());		
	}

	public T getCustomerID() {
		return customerID;
	}

	public void setCustomerID(T customerID) {
		this.customerID = customerID;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public static int getTotalDays() {
		return totalDays;
	}

	public static void setTotalDays(int totalDays) {
		IndividualCustomer.totalDays = totalDays;
	}

	public float calculateTotalPrice() {
		
		if(isMember()) {
			return (float) (getCar().calculateDailyPrice() * getTime() * (1 - 0.1));
		}
		else {
			return (float) (getCar().calculateDailyPrice() * getTime());
		}
	}
	
	public static int countCustomers(ArrayList<IndividualCustomer<Object>> customerList, boolean memberInfo) {
		
		int count = 0 ;
		Iterator<IndividualCustomer<Object>> iterator = customerList.iterator();
		while(iterator.hasNext()) {
			IndividualCustomer<Object> customer = iterator.next();
			if(customer.isMember() && memberInfo) {
				count++;
			}
			else if(!customer.isMember() && !memberInfo) {
				count++;
			}
		}
		return count;
	}

	public void showInformation(int no) {
		
		String checkMember;
		if(isMember()) {
			checkMember = "Yes";
		}
		else {
			checkMember = "No";
		}
		System.out.format("%1s %13s %18s %12s %14s %26s %12s %16s",String.valueOf(no), getCar().getRentalCode(), getCustomerID(), checkMember, getTime(), getCar().getCarModel(), 
				getCar().getCarModelYear(), getCar().getRentalPrice());
		System.out.println();
	}
	
	

}
