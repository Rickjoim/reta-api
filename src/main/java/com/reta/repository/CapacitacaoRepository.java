package com.reta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reta.model.Capacitacao;

@Repository
public interface CapacitacaoRepository extends JpaRepository<Capacitacao, Long> {
	@Query(value = "select c from Capacitacao c where trim(c.nome) like %?1%")
	List<Capacitacao> buscarPorNome(String nome);
}
