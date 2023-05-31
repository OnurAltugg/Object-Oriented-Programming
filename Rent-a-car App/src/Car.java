
public class Car {
	
	private String carModel;
	private int carModelYear;
	private double basePrice;
	private int rentalCode;
	private float rentalPrice;
	
	public Car(String carModel, int carModelYear, double basePrice) {
		this.carModel = carModel;
		this.carModelYear = carModelYear;
		this.basePrice = basePrice;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarModelYear() {
		return carModelYear;
	}

	public void setCarModelYear(int carModelYear) {
		this.carModelYear = carModelYear;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public int getRentalCode() {
		return rentalCode;
	}

	public void setRentalCode(int rentalCode) {
		this.rentalCode = rentalCode;
	}

	public float getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(float rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	
    public double calculateDailyPrice() {
		
		double modelYearRation = 0.0;
		if(carModelYear == 2022) {
			modelYearRation = 1;
		}
		else if(carModelYear >= 2020 && carModelYear <= 2021) {
			modelYearRation = 0.95;
		}
		else if(carModelYear >= 2017 && carModelYear <= 2019) {
			modelYearRation = 0.9;
		}
		return basePrice * modelYearRation;
	}

}
