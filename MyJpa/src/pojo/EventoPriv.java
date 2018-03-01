package pojo;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="PRIV")
public class EventoPriv extends Evento {

	private int id_pers;

	public EventoPriv() {
		super();
	}

	public EventoPriv(int id_evento, String nome, 
						int id_parco, List giochi, int id_pers) {
		super(id_evento, nome, id_parco, giochi);

		this.id_pers = id_pers;
	}

	public int getId_pers() {
		return id_pers;
	}

	public void setId_pers(int id_pers) {
		this.id_pers = id_pers;
	}
	
	@Override
	public String toString() {
		
		return "Evento PUB [" +
							getId_evento() 	+ ", " +
							getNome() 		+ ", " +
							getId_parco()	+ ", " +
							getId_pers()
						+ "]";
	}
}
