
public class Photo extends ApplicantInfo{
	
	private String resolution ;
	private String position ;

	public Photo(char information, String id, String resolution, String position) {
		
		super(information, id);
		this.resolution = resolution;
		this.position = position;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
    public String checkPhoto() {
		
		int firstValue = Integer.parseInt(resolution.substring(0, resolution.indexOf("x")));
		int secondValue = Integer.parseInt(resolution.substring(resolution.indexOf("x")+1));
		
		if(!(firstValue == secondValue && firstValue >= 600 && firstValue <= 1200 && secondValue >= 600 && secondValue <= 1200)) {
			return "Resolution of photo is not valid";
		}
		if(!(position.equals("Natural Smile") || position.equals("Neutral Face"))) {
			return "Position in the photo is not valid";
		}
		return "Correct Photo";
	}
	
	
	
}
