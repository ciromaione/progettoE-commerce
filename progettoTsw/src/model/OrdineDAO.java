package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdineDAO {
	
	public void doSave(Ordine o) {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO ordine (dataAcq, totale) VALUES (?, ?)");
			ps.setDate(1, o.getDataAcq());
			ps.setInt(2, o.getTotale());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
