package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdineDAO {
	
	public void doSave(Ordine o) {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO ordine (id, dataAcq, totale) VALUES (?, ?, ?)");
			ps.setInt(1, o.getId());
			ps.setDate(2, o.getDataAcq());
			ps.setInt(3, o.getTotale());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
