package pojo;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="PUB")
public class EventoPub extends Evento {

	private int npart;

	public EventoPub() {
		super();
	}

	public EventoPub(int id_evento, String nome, 
						int id_parco, List giochi, int npart) {
		super(id_evento, nome, id_parco, giochi);
		
		this.npart = npart;
	}

	public int getNpart() {
		return npart;
	}

	public void setNpart(int npart) {
		this.npart = npart;
	}
	
	@Override
	public String toString() {

		return "Evento PUB [" +
						getId_evento() 	+ ", " +
						getNome() 		+ ", " +
						getId_parco()	+ ", " +
						getNpart()
					+ "]";
	}
}
