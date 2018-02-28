package pojo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Animale implements pojo{

	private int id_animale = -1;
	private String razza = null;
	private int zampe = -1;
	private String genere = null;
	private String colore = null;
	private int id_persona = -1;

	
	public Animale(){}
	
	public Animale(int id_animale, String razza, int zampe, String genere, String colore, int id_persona){
		this.id_animale = id_animale;
		this.razza = razza;
		this.zampe = zampe;
		this.genere = genere;
		this.colore = colore;
		this.id_persona = id_persona;
	}
	
	public Animale(ResultSet rs) throws SQLException {
		
		this (rs.getInt("id_animale"), rs.getString("razza"), rs.getInt("zampe"), rs.getString("genere"), rs.getString("colore"), rs.getInt("id_persona"));
	}
	
	public int getId_animale() {
		return id_animale;
	}
	public void setId_animale(int id_animale) {
		this.id_animale = id_animale;
	}
	public String getRazza() {
		return razza;
	}
	public void setRazza(String razza) {
		this.razza = razza;
	}
	public int getZampe() {
		return zampe;
	}
	public void setZampe(int zampe) {
		this.zampe = zampe;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	@Override
	public boolean updateDB(Connection conn) {

		Statement stmt = null;
		
		try {
			stmt= conn.createStatement();
			stmt.executeUpdate("UPDATE Animale SET id_animale = "+getId_animale()+", razza = '"+getRazza()+"', zampe = "+getZampe()+", genere = '"+getGenere()+"', colore = '"+getColore()+ "', id_persona = "+getId_persona()+" WHERE id_animale = "+getId_animale());
			
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;

	}
	
	@Override
	public String toString() {
		return "Animale: "+getId_animale() + " | " + getRazza() + " | " + getZampe() + " | " + getGenere() + " | " + getColore()  + " | " + getId_persona();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Animale))
			return false;
		return getId_animale() == ((Animale) obj).getId_animale();
	}

	@Override
	public boolean insertDB(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO Animale VALUES ("+getId_animale()+", '"+getRazza()+"', "+getZampe()+", '"+getGenere()+"', '"+getColore()+"', "+ getId_persona() +")");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
