package com.reta.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reta.model.Oportunidade;
import com.reta.repository.OportunidadeRepository;

@RestController
@RequestMapping("/oportunidade")
public class OportunidadeController {

	@Autowired
	private OportunidadeRepository oportunidadeRepository;
	
	public OportunidadeController(OportunidadeRepository oportunidadeRepository){
		this.oportunidadeRepository = oportunidadeRepository;
	}
	
	@GetMapping("/")
	public List<Oportunidade> listar() {
		return oportunidadeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Oportunidade findById(@PathVariable("id") Long id){
		var oportunidadeVar = oportunidadeRepository.getById(id);
		return Oportunidade.converter(oportunidadeVar); 
	}
	
	@GetMapping(value = "/buscarPorNome") //Busca por Nome ou partes
	@ResponseBody
	public ResponseEntity<List<Oportunidade>> buscarPorNome(@RequestParam(required=false,name="nome") String nome){
		List<Oportunidade> oportunidade = oportunidadeRepository.buscarPorNome(nome.trim());
		return new  ResponseEntity<List<Oportunidade>>(oportunidade, HttpStatus.OK); 
	}
	
	@PostMapping
	public Oportunidade adicionar(@RequestBody Oportunidade oportunidade) {
		return oportunidadeRepository.save(oportunidade);
	}
	
	@PutMapping("/{id}")
	public Oportunidade atualizar(@PathVariable Long id, @RequestBody Oportunidade oportunidade){
		Oportunidade oportunidadeAtual = oportunidadeRepository.findById(id).get();
		BeanUtils.copyProperties(oportunidade, oportunidadeAtual, "id");
		return oportunidadeRepository.save(oportunidadeAtual); 
	}

}
