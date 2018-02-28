import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Esercizi {
	
		static final String USR = "Es_parchi",
							PSW = "password";
		
		static final String DRIVER = "oracle.jdbc.driver.OracleDriver",
							HOST = "localhost",
							DBNAME = "xe";
		static final int PORT = 1521;
		
		static final String DB_URL = "jdbc:oracle:thin:@" + HOST + ":" + PORT + ":" + DBNAME;
		
			
		static private Connection conn = null;  
		static private Statement stmt = null; 
		static private PreparedStatement pstmt = null;
		static private CallableStatement cstmt = null;
		static private ResultSet rs = null;  
		
		private static void openConn() throws ClassNotFoundException, SQLException {
			
			Class.forName(DRIVER);			
			conn = DriverManager.getConnection(DB_URL, USR, PSW); 
		}
		
		private static void closeConn() {
			
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
			
			conn = null;
			stmt = null;
			rs = null;
		}
		
		static private void stampaAnimali() {
			
			try {
				
				openConn();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT animale.razza, animale.genere, persona.nome "
								     + "FROM animale LEFT OUTER JOIN persona "
								     + "ON persona.id_persona = animale.id_persona");
				
				while(rs.next()) {
					String razza = rs.getString(1);
					String genere = rs.getString(2);
					String persona = rs.getString(3);
					
					if(rs.wasNull())
						persona = "RANDAGIO";
						
					System.out.println(
							razza + " : " +
							genere + " --> " + 
							persona
							);
				}	
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally { closeConn(); }
		}

		static private void aumentoIncasso() {
			
			try {
				
				openConn();
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery("SELECT * "
								     + "FROM struttura "
								     + "WHERE incasso > 0"
								     + "ORDER BY incasso");
				
			    rs.first();
				
				String tipo = rs.getString(2);
				int incasso = rs.getInt(6);
				
				rs = stmt.executeQuery("UPDATE struttura "
					     			 + "SET incasso = incasso * 1.25 " );
						
				System.out.println(
						tipo + " --> " +
						(incasso * 1.25)
						);
				
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally { closeConn(); }
		}
		
		static private void aumentoControllato(int id, int perce) {
			
			try {
				openConn();
				
				final String sql = "UPDATE Struttura SET incasso = incasso + ( incasso * ?)/100 "
						 + "WHERE id_struttura = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, perce);
				pstmt.setInt(2, id);
				
				System.out.println();
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{ closeConn(); }
		}
		
		static private void posizioneA3() {
			
			try {
				openConn();
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * "
									 + "FROM struttura "
									 + "WHERE posizione = 'A03'");
				
				while(rs.next()) {
					
					String id = rs.getString(1);
					String nome = rs.getString(2);
					String posizione = rs.getString(5);
					
					System.out.println("ID: " + id +
									   "   Struttura: " + nome + 
									   "   Posizione: " + posizione);
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { closeConn(); }
		}

		static private void animaliAssociati(String nome) {
			
			try {
				openConn();
				
				String sql = "{ call animaliAss(? , ?) }";
				
				cstmt = conn.prepareCall(sql);
				
				cstmt.setString(1, nome);
				cstmt.registerOutParameter(2, java.sql.Types.NUMERIC);
				
				cstmt.execute();
				
				int risul = cstmt.getInt(2);
				
				System.out.println(nome + " ha " + risul + " animali ");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { closeConn(); }
		}
		
		static private void parcoRegola() {
			
			try {
				openConn();
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT parco.nome, regola.descrizione" + 
						"	FROM Parco INNER JOIN RegolaParco" + 
						"	ON Parco.id_parco = RegolaParco.id_parco INNER JOIN Regola" + 
						"	ON Regola.id_regola = RegolaParco.id_regola");
				
				while(rs.next()) {
					
					String nome = rs.getString(1);
					String desc = rs.getString(2);
					
					System.out.println(nome + " --> " + desc);
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { closeConn(); }
			
		}
		
		static private void transazione() {
			
			Savepoint sp = null;
			
			try {
				openConn();
				conn.setAutoCommit(false);  // 
				sp = conn.setSavepoint("inizio_query");
				
				stmt = conn.createStatement();
				stmt.addBatch(" INSERT INTO Parco "
								+ " VALUES (7, 'PARCO JADEL CAFFE', 'JAVA', 2670, 'CREATA DAL CAFFE', 4) ");
				
				stmt.addBatch("UPDATE Parco "
							+ "SET dim = 200 "
							+ "WHERE id_parco = 8");
				
				int[] count = stmt.executeBatch();
				
				for (Integer c : count)
					System.out.println("Mod: " + c);
				
				System.out.println("Dati inseriti");
				conn.commit();
				
			} catch (ClassNotFoundException | SQLException e) {
				
				try {
					
					if(sp != null)
						conn.rollback(sp);
					else
						conn.rollback();
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} finally { closeConn(); }
		}

		private static void newRule() {
			
			try {
				openConn();
				
				stmt = conn.createStatement();
				
				stmt.executeQuery("INSERT INTO RegolaParco VALUES (7,2, {d '2020-01-03'}, {d '2020-01-06'})");
				
				System.out.println("Nuova RegolaParco inserita");
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public static void main(String[] args) {
			
			stampaAnimali();
			System.out.println();
			System.out.println("------------------");
			System.out.println();
			aumentoIncasso();
			System.out.println();
			System.out.println("------------------");
			System.out.println();
			aumentoControllato(1, 10);
			System.out.println("Controlla sul DB");
			System.out.println();
			System.out.println("------------------");
			System.out.println();
			posizioneA3();
			System.out.println();
			System.out.println("------------------");
			System.out.println();
			animaliAssociati("ANDREA");
			System.out.println();
			System.out.println("------------------");
			System.out.println();
			parcoRegola();
			System.out.println();
			System.out.println("------------------");
			System.out.println();
			transazione();
			System.out.println();
			System.out.println("------------------");
			System.out.println();
			newRule();
			System.out.println();
			System.out.println("------------------");
			System.out.println();

	}

	
}
