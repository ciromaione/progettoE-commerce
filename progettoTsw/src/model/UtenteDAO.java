package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtenteDAO {
	
	public void doSave(Utente u) {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO utente "
					+ "(nome, citta, indirizzo, email, pass, telefono) "
					+ "VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getCitta());
			ps.setString(3, u.getIndirizzo());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPass());
			ps.setString(6, u.getTelefono());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
