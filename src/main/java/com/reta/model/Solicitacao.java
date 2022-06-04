package com.reta.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Solicitacao {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String area;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Colaborador userColaborador;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Hospital userHospital;
	
	public static Solicitacao converter(Solicitacao s){
		var solicitacaoVar = new Solicitacao();
		solicitacaoVar.setId(s.getId());
		solicitacaoVar.setNome(s.getNome());
		solicitacaoVar.setDescricao(s.getDescricao());
		return solicitacaoVar;
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
		Solicitacao other = (Solicitacao) obj;
		return id == other.id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Hospital getUserHospital() {
		return userHospital;
	}

	public void setUserHospital(Hospital userHospital) {
		this.userHospital = userHospital;
	}
	

}
