package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RistoranteDAO {
	
	public void doSave(Ristorante risto) {
		try (Connection conn = ConnectionPool.getConnection()) {
			
			/*
			 * STATEMENT PER AGGIUNTA NELLA TABELLA RISTORANTE
			 */
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO ristorante (nome, citta, indirizzo, email, pass, telefono, oraAp, oraCh) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, risto.getNome());
			ps.setString(2, risto.getCitta());
			ps.setString(3, risto.getIndirizzo());
			ps.setString(4, risto.getEmail());
			ps.setString(5, risto.getPass());
			ps.setString(6, risto.getTelefono());
			ps.setString(7, risto.getOraAp());
			ps.setString(8, risto.getOraCh());
			ps.executeUpdate();
			
			/*
			 * Ricerca id ristorante appena inserito
			 */
			ps = conn.prepareStatement("SELECT id FROM ristorante WHERE email = ?");
			ps.setString(1, risto.getEmail());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) risto.setId(rs.getInt(1));
			else throw new RuntimeException();
			
			/*
			 * STATEMENT PER AGGIUNTA DELLE FOTO NELLA TABELLA FOTO
			 */
			String [] foto = risto.getFoto();
			if(foto == null) return;
			for(String f:foto) {
				ps = conn.prepareStatement("INSERT INTO foto (nome, idRisto) "
						+ "VALUES (?, ?)");
				ps.setString(1, f);
				ps.setInt(2, risto.getId());
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Ristorante doRetriveById(int id) {
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "SELECT id, nome, citta, indirizzo, email, pass, telefono, oraAp, oraCh "
					+ "FROM ristorante "
					+ "WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Ristorante risto = new Ristorante();
				risto.setId(rs.getInt(1));
				risto.setNome(rs.getString(2));
				risto.setCitta(rs.getString(3));
				risto.setIndirizzo(rs.getString(4));
				risto.setEmail(rs.getString(5));
				risto.setPass(rs.getString(6));
				risto.setTelefono(rs.getString(7));
				risto.setOraAp(rs.getString(8));
				risto.setOraCh(rs.getString(9));
				
				ps = conn.prepareStatement(""
						+ "SELECT nome "
						+ "FROM foto "
						+ "WHERE idRisto = ?");
				ps.setInt(1, risto.getId());
				rs = ps.executeQuery();
				rs.last();
				int size = rs.getRow();
				String foto [] = new String[size];
				rs.beforeFirst();
				for(int i = 0; i<size; ++i) {
					rs.next();
					foto[i] = rs.getString(1);
				}
				risto.setFoto(foto);
				
				return risto;
			}
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Ristorante doRetriveByEmail(String email) {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "SELECT id, nome, citta, indirizzo, email, pass, telefono, oraAp, oraCh "
					+ "FROM ristorante "
					+ "WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Ristorante risto = new Ristorante();
				risto.setId(rs.getInt(1));
				risto.setNome(rs.getString(2));
				risto.setCitta(rs.getString(3));
				risto.setIndirizzo(rs.getString(4));
				risto.setEmail(rs.getString(5));
				risto.setPass(rs.getString(6));
				risto.setTelefono(rs.getString(7));
				risto.setOraAp(rs.getString(8));
				risto.setOraCh(rs.getString(9));
				
				ps = conn.prepareStatement(""
						+ "SELECT nome "
						+ "FROM foto "
						+ "WHERE idRisto = ?");
				ps.setInt(1, risto.getId());
				rs = ps.executeQuery();
				rs.last();
				int size = rs.getRow();
				String foto [] = new String[size];
				rs.beforeFirst();
				for(int i = 0; i<size; ++i) {
					rs.next();
					foto[i] = rs.getString(1);
				}
				risto.setFoto(foto);
				return risto;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
