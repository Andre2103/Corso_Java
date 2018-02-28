package pojo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Regola implements pojo{

	private int id_regola = -1;
	private String nome = null;
	private String descrizione = null;
	private String tipo = null;

	
	public Regola(){}
	
	public Regola(int id_regola, String nome, String descrizione, String tipo){
		this.id_regola = id_regola;
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
	}
	
	public Regola(ResultSet rs) throws SQLException {
		
		this (rs.getInt("id_regola"), rs.getString("nome"), rs.getString("descrizione"), rs.getString("tipo"));
	}


	
	
	public int getId_regola() {
		return id_regola;
	}
	public void setId_regola(int id_regola) {
		this.id_regola = id_regola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public boolean updateDB(Connection conn) {

		Statement stmt = null;
		
		try {
			stmt= conn.createStatement();
			stmt.executeUpdate("UPDATE Regola SET id_regola = "+getId_regola()+", Nome = '"+getNome()+"', descrizione = '"+getDescrizione()+"', tipo = '"+getTipo()+"' WHERE Id_regola = "+getId_regola());
			
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
		return "Regola: "+getId_regola() + " | " + getNome() + " | " + getDescrizione() + " | " + getTipo();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Regola))
			return false;
		return getId_regola() == ((Regola) obj).getId_regola();
	}

	@Override
	public boolean insertDB(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO Regola VALUES ("+getId_regola()+", '"+getNome()+"', '"+getDescrizione()+"', '"+getTipo()+"')");
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
