package entity;

public class Weight {
	private int id;
	private int userId;
	private String measureDate;
	private String weight; 
	
	public Weight (int id, int userId, String measureDate, String weight) {
		this.setWeightsId (id);
		this.setUserId (userId);
		this.setMeasureDate (measureDate);
		this.setWeight (weight);
	}


	public int getWeightsId() {
		return id;
	}

	public void setWeightsId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMeasureDate() {
		return measureDate;
	}

	public void setMeasureDate(String measureDate) {
		this.measureDate = measureDate;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}

