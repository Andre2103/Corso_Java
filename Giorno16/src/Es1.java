import java.sql.*;

public class Es1 {
	
	// NOME UTENTE + PASSWORD DI ORACLE
	static final String USR = "Es_parchi",
						PSW = "password";
	
	// DRIVER DEL DATABASE
	static final String DRIVER = "oracle.jdbc.driver.OracleDriver",
						HOST = "localhost",
						DBNAME = "xe";
	static final int PORT = 1521;
	
	// URL DB 
	static final String DB_URL = "jdbc:oracle:thin:@" + HOST + ":" + PORT + ":" + DBNAME;
	
	private static void exConn(){
		
		Connection conn = null;  // CONNESSIONE CON IL DB
		Statement stmt = null;   // QUERY MANAGER ( PASSAGGIO DI QUERY )
		ResultSet rs = null;     // CONTENITORE RISULTATO QUERY
		
		//QUERY
		final String exSql = "SELECT * FROM Parco";
		
		try {
			// RICHIAMO AL DRIVER DB ( INTROSPECTION )
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(DB_URL, USR, PSW);  // INSTAURIAMO CONNESSIONE
			stmt = conn.createStatement(); // COLLEGAMENTO TRA DB E QUERY
			rs = stmt.executeQuery(exSql); // ESEGUIAMO QUERY
			
			// STAMPA DEI RISULTATI
			while(rs.next()) {
				int id= rs.getInt("ID_PARCO");
				String name = rs.getString("NOME");
				
				System.out.println("Il nome del parco è " + name);
			}
			
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}catch (SQLException e) {

			e.printStackTrace();

		} finally {
			
			if(rs != null) {
				
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		
		exConn();
	}
}
