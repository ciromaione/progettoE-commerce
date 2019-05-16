package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtenteDAO {
	
	public void doSave(Utente u) {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO utente "
					+ "(id, nome, citta, indirizzo, email, pass, telefono, nCarta, scadCarta, cvv) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, u.getId());
			ps.setString(2, u.getNome());
			ps.setString(3, u.getCitta());
			ps.setString(4, u.getIndirizzo());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getPass());
			ps.setString(7, u.getTelefono());
			ps.setString(8, u.getnCarta());
			ps.setString(9, u.getScadCarta());
			ps.setString(10, u.getCvv());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
