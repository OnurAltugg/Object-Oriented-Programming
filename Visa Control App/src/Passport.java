import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Passport extends ApplicantInfo {
	
	private String passportNumber;
	private String expirationDate;
	
	public Passport(char information, String id, String passportNumber, String expirationDate) {
		
		super(information, id);
		this.passportNumber = passportNumber;
		this.expirationDate = expirationDate;
		
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public String checkPassport() {

		int length = passportNumber.length();
		if(!(length == 10  && passportNumber.charAt(0) == 'P' && Character.isDigit(passportNumber.charAt(length-1)) && 
				Character.isDigit(passportNumber.charAt(length-2)) && Character.isDigit(passportNumber.charAt(length-3)))){
			return "Passport is not valid"; 
		}
		if(this.calculateTimeDifference(expirationDate) < 183) {
			return "Passport expiration date is not valid";
		}
		return "Correct Passport";
		
	}
	
    public long calculateTimeDifference(String endDate) {
		
		long timeDifference;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
		try {
			Date currentDate = new Date();
			Date finishDate = simpleDateFormat.parse(endDate);
		    timeDifference = finishDate.getTime() - currentDate.getTime();
		    return TimeUnit.DAYS.convert(timeDifference, TimeUnit.MILLISECONDS) + 1;
			
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return -1 ;
		
	}
	
	

}
