package pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Smartphone extends Pc {

	private String so;

	public Smartphone() {
		super();
	}

	public Smartphone(int id_pc, String nome, 
						String proc, Set giochi, String so) {
		super(id_pc, nome, proc, giochi);

		this.so = so;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}
	
	@Override
	public String toString() {

		return "Smartphone [" +
							getId_pc() 		+ ", " + 
							getNome() 		+ ", " + 
							getProc() 		+ ", " + 
							getSo()
						+ "]";
	}
}
