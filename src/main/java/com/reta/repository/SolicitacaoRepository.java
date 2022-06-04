package com.reta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reta.model.Solicitacao;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{
	@Query(value = "select s from Solicitacao s where trim(s.nome) like %?1%")
	List<Solicitacao> buscarPorNome(String nome);
}
