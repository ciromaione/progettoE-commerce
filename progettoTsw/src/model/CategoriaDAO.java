package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAO {
	
	public static String doRetriveById(int idCat) {
		
		try(Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT nome "
					+ "FROM categoria "
					+ "WHERE id = ?");
			ps.setInt(1, idCat);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
