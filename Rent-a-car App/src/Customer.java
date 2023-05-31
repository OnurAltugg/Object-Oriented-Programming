import java.util.ArrayList;
import java.util.Random;

public abstract class Customer implements Company {
	
	private int time;
	private Car car;
	
	public Customer(int time, Car car) {
		this.time = time;
		this.car = car;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public abstract float calculateTotalPrice();
	
	public abstract void showInformation(int no);
	
	public static <T> void createRentalCode(ArrayList<T> customerList) {
		
		int randomNumber;
		Random random = new Random();
		
		for(T customer : customerList) {
			
			int count = 0 ;
			String rentalCode = "";
			while(count != 7) {
				randomNumber = random.nextInt(10);
				if(randomNumber == 0 && count == 0) {
					continue;
				}
				rentalCode = rentalCode + String.valueOf(randomNumber);
				count++;
			}
			((Customer) customer).getCar().setRentalCode(Integer.parseInt(rentalCode));
		}
	}
	
	public static <T> void createRentalPrice(ArrayList<T> customerList) {
		
		for(T customer : customerList) {
			((Customer) customer).getCar().setRentalPrice(((Customer) customer).calculateTotalPrice());
		}
	}
	
}
