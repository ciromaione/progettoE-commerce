package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdottoDAO {
	
	public void doSave(Prodotto p){
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO prodotto (id, nome, descrizione, idCat, idRisto, prezzoCent) "
					+ "VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getDescrizione());
			ps.setInt(4, p.getIdCat());
			ps.setInt(5, p.getIdRisto());
			ps.setInt(6, p.getPrezzoCent());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
