package pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Gioco {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_gioco;
	private String nome;
	
	@ManyToMany(targetEntity=Pc.class)
	private Set pcs;
	
	public Gioco() {
		super();
	}
	public Gioco(int id_gioco, String nome, Set pcs) {
		super();
		this.id_gioco = id_gioco;
		this.nome = nome;
		this.pcs = pcs;
	}
	public int getId_gioco() {
		return id_gioco;
	}
	public void setId_gioco(int id_gioco) {
		this.id_gioco = id_gioco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set getPcs() {
		return pcs;
	}
	public void setPcs(Set pcs) {
		this.pcs = pcs;
	}
	
	
}
