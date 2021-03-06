package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class Users_dao {
	private Connection connection;
	private final String ADD_NAME = "INSERT INTO users (name) VALUES (?)";
	private final String DELETE_USER = "DELETE from users WHERE id = ?";
	
	public Users_dao() {
		connection = DBConnection.getInstance().getConnection();
	}
	
	public List<User> displayLog() throws SQLException{
		List<User> out = new ArrayList<>();
		
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery("select * from users");
		//u.id, u.name, w.userId, w.measureDate, w.weight from users u "
		//+ "INNER JOIN weights w ON u.userId = w.userId
		
		while (rs.next()) {
			out.add(new User (rs.getInt("id"), rs.getString("name")));
		}
		return out;
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
}
