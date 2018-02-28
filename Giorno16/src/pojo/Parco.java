package pojo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Parco implements pojo{

	private int id_parco = -1;
	private String nome = null;
	private String citta = null;
	private int dim = -1;
	private String carat = null;
	private int id_pers = -1;
	
	public Parco(int id_parco,
				 String nome,
				 String citta,
				 int dim,
				 String carat,
				 int id_pers) {
		
		this.id_parco = id_parco;
		this.nome = nome;
		this.citta = citta;
		this.dim = dim;
		this.carat = carat;
		this.id_pers = id_pers;
	}
	
	public Parco(ResultSet rs) throws SQLException {
		
		this(rs.getInt("id_parco"),
			 rs.getString("nome"),
			 rs.getString("citta"),
			 rs.getInt("dim"),
			 rs.getString("carat"),
			 rs.getInt("id_pers"));
	}

	
	public int getId_parco() {
		return id_parco;
	}

	public Parco setId_parco(int id_parco) {
		this.id_parco = id_parco;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Parco setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getCitta() {
		return citta;
	}

	public Parco setCitta(String citta) {
		this.citta = citta;
		return this;
	}

	public int getDim() {
		return dim;
	}

	public Parco setDim(int dim) {
		this.dim = dim;
		return this;
	}

	public String getCarat() {
		return carat;
	}

	public Parco setCarat(String carat) {
		this.carat = carat;
		return this;
	}

	public int getId_pers() {
		return id_pers;
	}

	public Parco setId_pers(int id_pers) {
		this.id_pers = id_pers;
		return this;
	}

	@Override
	public boolean updateDB(Connection conn) {

		return false;
	}
	
	@Override
	public boolean insertDB(Connection conn) {

		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO Parco VALUES ( "
					 + getId_parco() + ",'"
					 + getNome() + "','"
					 + getCitta() + "',"
					 + getDim() + ",'"
					 + getCarat() + "',"
					 + getId_pers() + " )");
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			
			try {
				if (stmt != null)
					stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
}
