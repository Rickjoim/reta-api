package com.reta.model;

import java.util.Objects;


//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Capacitacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int ch;
	private String descricao;
	private String tipo;
	private String Local;
	private String Titulo;
	private String ano;

	
	@ManyToOne
	@JoinColumn
	private Colaborador colaborador;
	
	public static Capacitacao converter(Capacitacao c){
		var capacitacaoVar = new Capacitacao();
		capacitacaoVar.setId(c.getId());
		capacitacaoVar.setNome(c.getNome());
		capacitacaoVar.setCh(c.getCh());
		capacitacaoVar.setDescricao(c.getDescricao());
		capacitacaoVar.setTipo(c.getTipo());
		capacitacaoVar.setLocal(c.getLocal());
		capacitacaoVar.setTitulo(c.getTitulo());
		capacitacaoVar.setAno(c.getAno());
		return capacitacaoVar;
	}
	

	public String getLocal() {
		return Local;
	}

	public void setLocal(String local) {
		Local = local;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Capacitacao other = (Capacitacao) obj;
		return id == other.id;
	}

	
	
}
