package entity;

public class User {
	private int id;
	private String name;
	
	public User (int id, String name) {
	this.setid (id);
	this.setName (name);
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}