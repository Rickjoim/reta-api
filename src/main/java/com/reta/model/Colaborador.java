package com.reta.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeCompleto;
	private String setor;
	private String cargo;
	private String email;
	
	private String senha;
	
	//List<Capacitacao> capacitacoes = new ArrayList<Capacitacao>();
	ArrayList<String> interesses = new ArrayList<>();
	
	public static Colaborador converter(Colaborador c){
		var colaboradorVar = new Colaborador();
		colaboradorVar.setId(c.getId());
		colaboradorVar.setNomeCompleto(c.getNomeCompleto());
		colaboradorVar.setCargo(c.getCargo());
		colaboradorVar.setSetor(c.getSetor());
		//colaboradorVar.setCapacitacoes(c.getCapacitacoes());
		colaboradorVar.setEmail(c.getEmail());
		colaboradorVar.setInteresses(c.getInteresses());
		return colaboradorVar;
	}
	
	 ArrayList<String> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<String> interesses) {
		this.interesses = (ArrayList<String>) interesses;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//public List<Capacitacao> getCapacitacoes() {
	//	return capacitacoes;
	//}

	//public void setCapacitacoes(List<Capacitacao> capacitacoes) {
	//	this.capacitacoes = capacitacoes;
	//}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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
