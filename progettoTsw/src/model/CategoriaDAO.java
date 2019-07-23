package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public static ArrayList<Categoria> doRetriveAll() {
		
		try(Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT id, nome "
					+ "FROM categoria ");
			ResultSet rs = ps.executeQuery();
			ArrayList<Categoria> cat = new ArrayList<Categoria>();
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				cat.add(c);
			}
			return cat;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
