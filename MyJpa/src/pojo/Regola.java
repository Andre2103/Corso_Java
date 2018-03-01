package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(
			query = "SELECT r "
				  + "FROM Regola r "
				  + "WHERE r.id_regola = :id",
				  
			name = "getRuleFromId"
		)
public class Regola {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id_regola;
	String nome;
	String descriz;
	String tipo;
	
	public Regola() {
		super();
	}
	public Regola(int id_regola, String nome, 
					String descriz, String tipo) {
		super();
		
		this.id_regola = id_regola;
		this.nome = nome;
		this.descriz = descriz;
		this.tipo = tipo;
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
	public String getDescriz() {
		return descriz;
	}
	public void setDescriz(String descriz) {
		this.descriz = descriz;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {

		return "Regola [" +
						getId_regola() 	+ ", " +
						getNome() 		+ ", " +
						getDescriz()	+ ", " +
						getTipo()
					+ "]";
	}
}
