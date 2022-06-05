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
	
	private String tema;
	private String tipo;
	private String publicoAlvo;
	private String justificativa;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Colaborador userColaborador;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Hospital userHospital;
	
	public static Solicitacao converter(Solicitacao s){
		var solicitacaoVar = new Solicitacao();
		solicitacaoVar.setId(s.getId());
		solicitacaoVar.setTema(s.getTema());
		solicitacaoVar.setTipo(s.getTipo());
		solicitacaoVar.setPublicoAlvo(s.getPublicoAlvo());
		solicitacaoVar.setJustificativa(s.getJustificativa());
		return solicitacaoVar;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPublicoAlvo() {
		return publicoAlvo;
	}

	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
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

	public Hospital getUserHospital() {
		return userHospital;
	}

	public void setUserHospital(Hospital userHospital) {
		this.userHospital = userHospital;
	}
	

}
