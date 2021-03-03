package entity;

public class UserEntity {
	private int userId;
	private String name;
	private String email;
	
	public UserEntity (int userId, String name, String email) {
	this.setUserId (userId);
	this.setName (name);
	this.setEmail (email);
	
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}