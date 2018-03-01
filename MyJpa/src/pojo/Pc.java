package pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Pc {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_pc;
	private String nome;
	private String proc;
	
	@ManyToMany(targetEntity=Gioco.class)
	private Set giochi;
	
	public Pc() {
		super();
	}

	public Pc(int id_pc, String nome, String proc, Set giochi) {
		super();
		this.id_pc = id_pc;
		this.nome = nome;
		this.proc = proc;
		this.giochi = giochi;
	}

	public int getId_pc() {
		return id_pc;
	}

	public void setId_pc(int id_pc) {
		this.id_pc = id_pc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProc() {
		return proc;
	}

	public void setProc(String proc) {
		this.proc = proc;
	}

	public Set getGiochi() {
		return giochi;
	}

	public void setGiochi(Set giochi) {
		this.giochi = giochi;
	}

	
}
