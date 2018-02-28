package pojo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegolaParco implements pojo{

	private int id_parco = -1;
	private int id_regola = -1;
	private String iniziodate = null;
	private String finedate = null;

	
	public RegolaParco(){}
	
	public RegolaParco(int id_parco, int id_regola, String iniziodate, String finedate){
		this.id_parco = id_parco;
		this.id_regola = id_regola;
		this.iniziodate = iniziodate;
		this.finedate = finedate;
	}
	
	public RegolaParco(ResultSet rs) throws SQLException {
		
		this (rs.getInt("id_parco"), rs.getInt("id_regola"), rs.getString("iniziodate"), rs.getString("finedate"));
	}


	public int getId_parco() {
		return id_parco;
	}

	public void setId_parco(int id_parco) {
		this.id_parco = id_parco;
	}

	public int getId_regola() {
		return id_regola;
	}

	public void setId_regola(int id_regola) {
		this.id_regola = id_regola;
	}

	public String getIniziodate() {
		return iniziodate;
	}

	public void setIniziodate(String iniziodate) {
		this.iniziodate = iniziodate;
	}

	public String getFinedate() {
		return finedate;
	}

	public void setFinedate(String finedate) {
		this.finedate = finedate;
	}

	@Override
	public boolean updateDB(Connection conn) {

		Statement stmt = null;
		
		try {
			stmt= conn.createStatement();
			stmt.executeUpdate("UPDATE RegolaParco SET id_parco = "+getId_parco()+", id_regola = "+getId_regola()+", iniziodate = "+getIniziodate()+", finedate = "+getFinedate()+" WHERE Id_regola = "+getId_regola() + "AND id_parco = "+getId_parco());
			
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
		return "RegolaParco: "+getId_parco() + " | " + getId_regola() + " | " + getIniziodate() + " | " + getFinedate();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof RegolaParco))
			return false;
		return getId_regola() == ((RegolaParco) obj).getId_regola();
	}

	@Override
	public boolean insertDB(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO RegolaParco VALUES ("+getId_parco()+", "+getId_regola()+", "+getIniziodate()+", "+getFinedate()+")");
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
