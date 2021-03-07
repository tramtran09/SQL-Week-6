package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;



public class Users_dao {
	private Connection connection;
	private final String ADD_NAME = "INSERT INTO users (name) VALUES (?)";
	private final String DELETE_USER = "DELETE from users WHERE id = ?";
	
	public Users_dao() {
		connection = DBConnection.getInstance().getConnection();
	}
	
	public void enterNewName(String name) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(ADD_NAME);
		ps.setString(1, name);
		ps.executeUpdate();
	}
	
	public void deleteUserById(int id) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(DELETE_USER);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	public void close() {
		DBConnection.getInstance().closeConnection();
	}

}
