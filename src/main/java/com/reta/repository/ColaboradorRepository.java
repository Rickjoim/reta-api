package com.reta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reta.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
	@Query(value = "select c from Colaborador c where trim(c.nome) like %?1%")
	List<Colaborador> buscarPorNome(String nome);
}
