package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdottoXOrdineDAO {
	
	public void doSave(ProdottoXOrdine po) {

		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO prodottoXordine (idProd, idOrdine, quantita) VALUES (?, ?, ?)");
			ps.setInt(1, po.getIdProd());
			ps.setInt(2, po.getIdOrdine());
			ps.setInt(3, po.getQuantita());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
