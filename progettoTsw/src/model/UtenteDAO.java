package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public Utente doRetriveByEmail(String email) {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "SELECT id, nome, citta, indirizzo, telefono, pass "
					+ "FROM utente "
					+ "WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Utente u = new Utente();
				u.setId(rs.getInt(1));
				u.setNome(rs.getString(2));
				u.setCitta(rs.getString(3));
				u.setIndirizzo(rs.getString(4));
				u.setTelefono(rs.getString(5));
				u.setEmail(email);
				u.setPass(rs.getString(6));
				return u;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
