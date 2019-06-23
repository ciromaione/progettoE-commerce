package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FotoIndexPool {

	public static int getLastFotoIndex() {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			int index;
			PreparedStatement ps = conn.prepareStatement(""
					+ "SELECT MAX(id) "
					+ "FROM foto");
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) index = rs.getInt(1);
			else index = 0;
			
			return index;
			
		} catch (SQLException e) {
			return -1;
		}
		
	}

}
