package pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_gioco")
public class GiocoAd extends Gioco {

	private int eta_min;
	private boolean ass;
	
	public GiocoAd() {
		super();
	}

	public GiocoAd(int id_gioco, String nome,  Set pcs,
					int eta_min, boolean ass) {
		super(id_gioco, nome, pcs);
		this.eta_min = eta_min;
		this.ass = ass;
	}

	public int getEta_min() {
		return eta_min;
	}

	public void setEta_min(int eta_min) {
		this.eta_min = eta_min;
	}

	public boolean isAss() {
		return ass;
	}

	public void setAss(boolean ass) {
		this.ass = ass;
	}
	
	@Override
	public String toString() {

		return "Gioco AD [" +
							getId_gioco() 	+ ", " + 
							getNome() 		+ ", " + 
							getEta_min() 	+ ", " + 
							isAss()
						+ "]";
	}
}
