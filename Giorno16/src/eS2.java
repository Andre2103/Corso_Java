import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import pojo.Animale;
import pojo.Parco;
import pojo.Persona;
import pojo.Regola;
import pojo.RegolaParco;
import pojo.Struttura;

public class eS2 {
	
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
		
		static private void leggiParco() {

			
			try {
				
				openConn();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM Parco");
				
				while(rs.next()) {
					
					int id = rs.getInt(1);
					String nome = rs.getString(2);
					String city = rs.getString(3);
					int dim = rs.getInt(4);
					String carat = rs.getString(5);
					
					System.out.println(
							"Id: " + id + "   " +
							"Nome: " + nome + "   " +
							"Città: " + city + "   " +
							"Dimensione: " + dim + "   " +
							"Caratteristichr: " + carat
							);
				}
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				
				closeConn();
			}
		}
		
		private static void printParco(ResultSet rs) throws SQLException {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String city = rs.getString(3);
			int dim = rs.getInt(4);
			String carat = rs.getString(5);
			
			System.out.println(
					"Id: " + id + "   " +
					"Nome: " + nome + "   " +
					"Città: " + city + "   " +
					"Dimensione: " + dim + "   " +
					"Caratteristichr: " + carat
					);
		}
		
		private static void updateParco() {
			
			try {
				openConn();
				stmt = conn.createStatement();
				
				final String sql = "UPDATE Parco SET dim = 700 "
								 + "WHERE id_parco = 5";
				
				boolean hasRs = stmt.execute(sql); // Testa la query e ci dice se ci da il risultato o no
				
				if (!hasRs) {
					int affRow = stmt.executeUpdate(sql);
					System.out.println("Sono state aggiornate " + affRow + " righe");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn();
			}
		} 
		
		private static void updateParam(int id, int dim) {
			
			try {
				openConn();
				
				final String sql = "UPDATE Parco SET dim   = ?"
								 + "WHERE id_parco = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dim);
				pstmt.setInt(2, id);
				
				int affRow = pstmt.executeUpdate();
				System.out.println("Righe modificate: " + affRow + " righe");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn();
			}
			
		}
		
		private static void callProc(int id) {
			
			try {
				openConn();
				
				String sql = "{call getParco(? , ?)}";
				
				cstmt = conn.prepareCall(sql);
				
				cstmt.setInt(1, id);
				cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				
				cstmt.execute();
				
				String name = cstmt.getString(2);
				
				System.out.println(id + ": " + name);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn();
			}
		}
		
		public static void advStmt() {
			
			try {
				openConn();
				
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				rs = stmt.executeQuery("SELECT * FROM Parco");
				
				rs.first();
				printParco(rs);
				
				rs.last();
				printParco(rs);
				
				rs.absolute(3);
				printParco(rs);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConn();
			}
		}
		
		public static void updAdvStmt () {
			
			try {
				openConn();
				
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery("SELECT id_parco, NOME, CITTA, DIM, CARATTERISTICHE, id_persona FROM Parco");
				
				rs.absolute(4);
				rs.updateInt("dim", 4000);
				rs.updateRow();
				
				printParco(rs);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConn();
			}
		}
		
		public static void nullHandle() {
			
			try {
				openConn();
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT nome, caratteristiche FROM parco");
				
				while(rs.next()) {
					
					String nome = rs.getString("nome");
					String carat = rs.getString("caratteristiche");
					
					if(rs.wasNull())
						carat = "unknow";
					
					System.out.println(nome + " : " + carat);
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
				stmt.executeUpdate(" INSERT INTO Parco "
								+ " VALUES (7, 'PARCO JADEL CAFFE', 'JAVA', 2670, 'CREATA DAL CAFFE', 4) ");
				sp = conn.setSavepoint();
				stmt.executeUpdate("UPDATE Parco "
							+ "SET dim = 200 "
							+ "WHERE id_parco = 8");
				
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
		
		private static void pojoInsert() {
			
			try {
				openConn();
				
				//Parco p = new Parco(17,"Cosa cazzo è", "Palazzo Q7", 7489, "Non lo so" , 3);
				Persona per = new Persona (10, "Andrew", 34 , "M", "SPA");
				//Animale ani = new Animale (8, "KITTI" , "M", "VIOLA");
				//Regola reg = new Regola (7, "KITTI" , "M", "VIOLA");
				//RegolaParco regpar = new RegolaParco(2,3, "{d '2012-05-03'}","{d '2020-05-03'}") ;
				//Struttura str = new Struttura(9, "PINO", 3, null, "A08", 3, 5, 3);
				per.insertDB(conn);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeConn();
			}
		}
		
		public static void pojoUpdate() {
			try {
				openConn();
				//Parco p = new Parco(12, "pojo parco", "Milano", 4000, "mio car3", 1);
				Persona per = new Persona (1, "Andrew", 34 , "M", "SPA");
				//Animale ani = new Animale (3, "YEYE", "F", "BLU");
				//Regola reg = new Regola (3, "YEYE", "F", "BLU");
				//RegolaParco regpar = new RegolaParco(4,3, "{d '2012-05-03'}","{d '2020-05-03'}");
				//Struttura str = new Struttura(4, "PINO", 3, null, "A03", 2, 4, 1);
				System.out.println("Modifica fatta a: "+per.toString());
				per.updateDB(conn);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} finally {
				closeConn();
			}
		}

		
		public static void main(String[] args) {

		//updateParam(3,5);
		
		//callProc(2);
		
		//updAdvStmt ();
		
		//transazione();
		System.out.println();
		//System.out.println("------------------");
		System.out.println();
		//newRule();
		System.out.println();
		//System.out.println("------------------");
		System.out.println();
		pojoInsert();
		System.out.println("------------------");
		pojoUpdate();

	}
		
		
		
		
	
}
