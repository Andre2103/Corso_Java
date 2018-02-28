package pojo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Struttura implements pojo{

	private int id_struttura = -1;
	private String tipologia = null;
	private int dimensione = -1;
	private String prossima_manuntenzione = null;
	private String posizione = null;
	private int incasso = -1;
	private int id_parco = -1;
	private int id_persona = -1;

	
	public Struttura(){}
	
	public Struttura(int id_struttura, String tipologia, int dimensione, String prossima_manuntenzione,
			String posizione, int incasso, int id_parco, int id_persona){
		this.id_struttura = id_struttura;
		this.tipologia = tipologia;
		this.dimensione = dimensione;
		this.prossima_manuntenzione = prossima_manuntenzione;
		this.posizione = posizione;
		this.incasso = incasso;
		this.id_parco = id_parco;
		this.id_persona = id_persona;
	}
	
	public Struttura(ResultSet rs) throws SQLException {
		
		this (rs.getInt("id_struttura"), rs.getString("tipologia"),
			  rs.getInt("dimensione"), rs.getString("prossima_manuntenzione"), rs.getString("posizione"),
			  rs.getInt("incasso"), rs.getInt("id_parco"), rs.getInt("id_persona"));
	}
	
	
	


	public int getId_struttura() {
		return id_struttura;
	}

	public void setId_struttura(int id_struttura) {
		this.id_struttura = id_struttura;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public int getDimensione() {
		return dimensione;
	}

	public void setDimensione(int dimensione) {
		this.dimensione = dimensione;
	}

	public String getProssima_manuntenzione() {
		return prossima_manuntenzione;
	}

	public void setProssima_manuntenzione(String prossima_manuntenzione) {
		this.prossima_manuntenzione = prossima_manuntenzione;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public int getIncasso() {
		return incasso;
	}

	public void setIncasso(int incasso) {
		this.incasso = incasso;
	}

	public int getId_parco() {
		return id_parco;
	}

	public void setId_parco(int id_parco) {
		this.id_parco = id_parco;
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
			stmt.executeUpdate("UPDATE Struttura SET tipologia = '"+getTipologia()+"'"
					+ ", dimensione = "+getDimensione()+", prossima_manuntenzione = "+getProssima_manuntenzione()
					+ ", posizione = '"+getPosizione()+"', incasso = "+getIncasso()
					+ ", id_parco = "+getId_parco()+", id_persona = "+getId_persona()
					+ " WHERE Id_struttura = "+getId_struttura());
			
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
		return "Struttura: "+getId_struttura() + " | " + getTipologia() + " | " + getDimensione() + " | " + getProssima_manuntenzione() + " | " +
							 getPosizione() + " | "+getIncasso() + " | "+getId_parco() + " | "+getId_persona();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Struttura))
			return false;
		return getId_struttura() == ((Struttura) obj).getId_struttura();
	}

	@Override
	public boolean insertDB(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO Struttura VALUES ("+getId_struttura()+", '"+getTipologia()+"', "+getDimensione()+", "+getProssima_manuntenzione()+", '"
					+ getPosizione() + "', " + getIncasso() + ", "+ getId_parco() + ", "+ getId_persona()+ " )");
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
