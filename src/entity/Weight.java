package entity;

public class Weight {
	private int weightsId;
	private int userId;
	private String measureDate;
	private double weight; 
	
	public Weight (int weightsID, int userId, String measureDate, double weight) {
		this.setWeightsId (weightsId);
		this.setUserId (userId);
		this.setMeasureDate (measureDate);
		this.setWeight (weight);
		
	}

	public int getWeightsId() {
		return weightsId;
	}

	public void setWeightsId(int weightsID) {
		this.weightsId = weightsID;
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}

