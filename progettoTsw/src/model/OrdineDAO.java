package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class OrdineDAO {
	
	public int doRetriveLastId() {
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "SELECT MAX(id) FROM ordine");
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getInt(1);
			else return -1;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void doSave(Ordine o) {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO ordine (dataAcq, totale, idUtente, id) VALUES (?, ?, ?, ?)");
			ps.setDate(1, o.getDataAcq());
			ps.setInt(2, o.getTotale());
			ps.setInt(3, o.getIdUtente());
			ps.setInt(4, o.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public TreeSet<Ordine> doRetriveByUser(Utente u) {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			TreeSet<Ordine> ordini = new TreeSet<>((x,y) -> {if(x.getDataAcq().compareTo(y.getDataAcq())>0) return -1;
				else if(x.getDataAcq().compareTo(y.getDataAcq())<0) return 1;
				else return 0;});
			PreparedStatement ps = conn.prepareStatement(""
					+ "SELECT id, dataAcq, totale, idUtente "
					+ "FROM ordine "
					+ "WHERE idUtente = ? ");
			ps.setInt(1, u.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Ordine o = new Ordine();
				o.setId(rs.getInt(1));
				o.setDataAcq(rs.getDate(2));
				o.setTotale(rs.getInt(3));
				o.setIdUtente(rs.getInt(4));
				ordini.add(o);
			}
			return ordini;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
