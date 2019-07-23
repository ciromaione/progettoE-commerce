package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDAO {
	
	public void doSave(Prodotto p){
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO prodotto (nome, descrizione, idCat, idRisto, prezzoCent) "
					+ "VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, p.getNome());
			ps.setString(2, p.getDescrizione());
			ps.setInt(3, p.getIdCat());
			ps.setInt(4, p.getIdRisto());
			ps.setInt(5, p.getPrezzoCent());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public Prodotto doRetriveById(int idProd) {
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "SELECT id, nome, descrizione, idCat, idRisto, prezzoCent "
					+ "FROM prodotto "
					+ "WHERE id = ?");
			ps.setInt(1, idProd);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Prodotto p = new Prodotto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setDescrizione(rs.getString(3));
				p.setIdCat(rs.getInt(4));
				p.setIdRisto(rs.getInt(5));
				p.setPrezzoCent(rs.getInt(6));
				
				return p;
			}
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Prodotto> doRetriveMenu(int idRisto) {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "SELECT p.id, p.nome, p.descrizione, p.idCat, p.idRisto, p.prezzoCent "
					+ "FROM prodotto p "
					+ "WHERE p.idRisto = ?");
			ps.setInt(1, idRisto);
			ResultSet rs = ps.executeQuery();
			ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
			while(rs.next()) {
				Prodotto p = new Prodotto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setDescrizione(rs.getString(3));
				p.setIdCat(rs.getInt(4));
				p.setIdRisto(rs.getInt(5));
				p.setPrezzoCent(rs.getInt(6));
				prodotti.add(p);
			}
			return prodotti;
					
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		
	}


	public void doRemoveById(int id) {

		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "DELETE FROM prodotto "
					+ "WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
