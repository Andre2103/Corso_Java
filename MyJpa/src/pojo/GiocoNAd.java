package pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_gioco")
public class GiocoNAd extends Gioco {

	private int eta_max;
	private char genere;
	
	public GiocoNAd() {
		super();
	}

	public GiocoNAd(int id_gioco, String nome,  Set pcs,
					int eta_max, char genere) {
		super(id_gioco, nome, pcs);
		this.eta_max = eta_max;
		this.genere = genere;
	}

	public int getEta_max() {
		return eta_max;
	}

	public void setEta_max(int eta_max) {
		this.eta_max = eta_max;
	}

	public char getGenere() {
		return genere;
	}

	public void setGenere(char genere) {
		this.genere = genere;
	}
	
	@Override
	public String toString() {

		return "Gioco AD [" +
				getId_gioco() 	+ ", " + 
				getNome() 		+ ", " + 
				getEta_max() 	+ ", " +
				getGenere()
			+ "]";
	}
}
