package com.reta.model;

import java.util.ArrayList;
import java.util.Objects;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String setor;
	private String especialidade;
	private String cargo;
	private String email;
	
	@ManyToOne
	@JoinColumn
	private Hospital userHospital;
	
	//ArrayList<Capacitacao> capacitacoes = new ArrayList<Capacitacao>();
	//ArrayList<String> interesses = new ArrayList<>();
	
	public static Colaborador converter(Colaborador c){
		var colaboradorVar = new Colaborador();
		colaboradorVar.setId(c.getId());
		colaboradorVar.setNome(c.getNome());
		colaboradorVar.setCargo(c.getCargo());
		colaboradorVar.setSetor(c.getSetor());
		//colaboradorVar.setCapacitacoes(c.getCapacitacoes());
		colaboradorVar.setEmail(c.getEmail());
		return colaboradorVar;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	//void setInteresses(ArrayList<String> interesses) {
	//	 this.interesses = interesses;
	//}
	
	//public ArrayList<String> getInteresses() {
	//	return interesses;
	//}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	//public ArrayList<Capacitacao> getCapacitacoes() {
	//	return capacitacoes;
	//}

	//public void setCapacitacoes(ArrayList<Capacitacao> capacitacoes) {
	//	this.capacitacoes = capacitacoes;
	//}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		return id == other.id;
	}
	
	
}
