package pojo;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipologia")
public abstract class Evento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_evento;
	private String nome;
	private int id_parco;
	
	@OneToMany(targetEntity=Gioco.class)
	private List giochi;
	
	public Evento() {
		super();
	}
	public Evento(int id_evento, String nome, 
					int id_parco, List giochi) {
		super();
		this.id_evento = id_evento;
		this.nome = nome;
		this.id_parco = id_parco;
		this.giochi = giochi;
	}
	public int getId_evento() {
		return id_evento;
	}
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId_parco() {
		return id_parco;
	}
	public void setId_parco(int id_parco) {
		this.id_parco = id_parco;
	}
	
	public List getGiochi() {
		return giochi;
	}
	public void setGiochi(List giochi) {
		this.giochi = giochi;
	}
	
	@Override
	public String toString() {

		return "Evento [" +
						getId_evento() 	+ ", " +
						getNome() 		+ ", " +
						getId_parco()
					+ "]";
	}
}
