package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RistoranteDAO {
	
	public void doSave(Ristorante risto) {
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO ristorante (nome, cap_citta, indirizzo, email, pass, telefono, oraAp, oraCh) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, risto.getNome());
			ps.setInt(2, risto.getCapCitta());
			ps.setString(3, risto.getIndirizzo());
			ps.setString(4, risto.getEmail());
			ps.setString(5, risto.getPass());
			ps.setString(6, risto.getTelefono());
			ps.setString(7, risto.getOraAp());
			ps.setString(8, risto.getOraCh());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Ristorante doRetriveById(int id) {
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "SELECT id, nome, cap_citta, indirizzo, email, pass, telefono, oraAp, oraCh "
					+ "FROM ristorante "
					+ "WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Ristorante risto = new Ristorante();
				risto.setId(rs.getInt(1));
				risto.setNome(rs.getString(2));
				risto.setCapCitta(rs.getInt(3));
				risto.setIndirizzo(rs.getString(4));
				risto.setEmail(rs.getString(5));
				risto.setPass(rs.getString(6));
				risto.setTelefono(rs.getString(7));
				risto.setOraAp(rs.getString(8));
				risto.setOraCh(rs.getString(9));
				return risto;
			}
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
