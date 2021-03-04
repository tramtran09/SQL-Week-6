package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Weights_dao {
private Connection connection;
private final String ADD_WEIGHT = "INSERT INTO weights (user_id, measureDate, weight) VALUES (?,?,?)";
	
	public Weights_dao() {
		connection = DBConnection.getInstance().getConnection();
	}
	
	public void enterNewWeight(int userId,String measureDate, int weight) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(ADD_WEIGHT);
		ps.setInt(1, userId);
		ps.setString(2, measureDate);
		ps.setInt(3, weight);
		ps.executeUpdate();
	}
	

	
}
