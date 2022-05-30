package com.reta.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String nomeFantasia;
	//private String username;
	private String cnpj;
	private String email;
	private long telefone;
	private String endereco;
	private long cep;
	private String municipio;
	//private String senha;
	
	public static Hospital converter(Hospital o){
		var userHospitalVar = new Hospital();
		userHospitalVar.setId(o.getId());
		userHospitalVar.setNome(o.getNome());
		userHospitalVar.setCnpj(o.getCnpj());
		userHospitalVar.setEndereco(o.getEndereco());
		userHospitalVar.setEmail(o.getEmail());
		//userHospitalVar.setUsername(o.getUsername());
		userHospitalVar.setTelefone(o.getTelefone());
		userHospitalVar.setCep(o.getCep());
		userHospitalVar.setMunicipio(o.getMunicipio());
		//userHospitalVar.setSenha(o.getSenha());
		return userHospitalVar;
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
		Hospital other = (Hospital) obj;
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
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	/*
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	*/
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	/*public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}*/

}
