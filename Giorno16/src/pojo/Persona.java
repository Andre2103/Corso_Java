package pojo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Persona implements pojo{

	private int id_persona = -1;
	private String nome = null;
	private int eta = -1;
	private String genere = null;
	private String nazionalita = null;

	
	public Persona(){}
	
	public Persona(int id_persona, String nome, int eta, String genere, String nazionalita){
		this.id_persona = id_persona;
		this.nome = nome;
		this.eta = eta;
		this.genere = genere;
		this.nazionalita = nazionalita;
	}
	
	public Persona(ResultSet rs) throws SQLException {
		
		this (rs.getInt("id_persona"), rs.getString("nome"), rs.getInt("eta"), rs.getString("genere"), rs.getString("nazionalita"));
	}


	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	
	@Override
	public boolean updateDB(Connection conn) {

		Statement stmt = null;
		
		try {
			stmt= conn.createStatement();
			stmt.executeUpdate("UPDATE PERSONA SET Id_PERSONA = "+getId_persona()+", Nome = '"+getNome()+"', eta = "+getEta()+", genere = '"+getGenere()+"', NAZIONALITA = '"+getNazionalita()+ "' WHERE Id_persona = "+getId_persona());
			
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
		return "PERSONA: "+getId_persona() + " | " + getNome() + " | " + getEta() + " | " + getGenere() + " | " + getNazionalita();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Persona))
			return false;
		return getId_persona() == ((Persona) obj).getId_persona();
	}

	@Override
	public boolean insertDB(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO Persona VALUES ("+getId_persona()+", '"+getNome()+"', "+getEta()+", '"+getGenere()+"', '"+getNazionalita()+"')");
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
