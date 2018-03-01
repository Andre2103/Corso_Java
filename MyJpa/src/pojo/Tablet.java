package pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Tablet extends Pc {

	private int monitor;
	private boolean bt;
	
	public Tablet() {
		super();
	}
	public Tablet(int id_pc, String nome, String proc, Set giochi,
					int monitor, boolean bt) {
		super(id_pc, nome, proc, giochi);
		this.monitor = monitor;
		this.bt = bt;
	}
	public int getMonitor() {
		return monitor;
	}
	public void setMonitor(int monitor) {
		this.monitor = monitor;
	}
	public boolean isBt() {
		return bt;
	}
	public void setBt(boolean bt) {
		this.bt = bt;
	}
	
	@Override
	public String toString() {

		return "Tablet [" +
							getId_pc() 		+ ", " + 
							getNome() 		+ ", " + 
							getProc() 		+ ", " + 
							getMonitor() 	+ ", " + 
							isBt()
					+ "]";
	}
}
