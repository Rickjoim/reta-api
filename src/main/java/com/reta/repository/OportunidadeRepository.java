
package com.reta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reta.model.Oportunidade;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long>{
	
	@Query(value = "select c from Oportunidade c where trim(c.nome) like %?1%")
	List<Oportunidade> buscarPorNome(String nome);

}
