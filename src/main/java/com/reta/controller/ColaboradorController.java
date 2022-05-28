package com.reta.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import com.reta.model.Colaborador;
import com.reta.repository.ColaboradorRepository;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	public ColaboradorController(ColaboradorRepository colaboradorRepository){
		this.colaboradorRepository = colaboradorRepository;
	}
	
	@GetMapping("/")
	public List<Colaborador> listar() {
		return colaboradorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Colaborador findById(@PathVariable("id") Long id){
		var colaboradorVar = colaboradorRepository.getById(id);
		return Colaborador.converter(colaboradorVar); 
	}
	
	//@GetMapping(value = "/buscarPorNome") //Busca por nome ou partes
	//@ResponseBody
	//public ResponseEntity<List<Colaborador>> buscarPorNome(@RequestParam(required=false,name="nome") String nome){
	//	List<Colaborador> colaborador = colaboradorRepository.buscarPorNome(nome.trim());
	//	return new  ResponseEntity<List<Colaborador>>(colaborador, HttpStatus.OK); 
	//}
	
	@PostMapping
	public Colaborador adicionar(@RequestBody Colaborador colaborador) {
		return colaboradorRepository.save(colaborador);
	} 
	
	@PutMapping("/{id}")
	public Colaborador atualizar(@PathVariable Long id, @RequestBody Colaborador colaborador){
		Colaborador colaboradorAtual = colaboradorRepository.findById(id).get();
		BeanUtils.copyProperties(colaborador, colaboradorAtual, "id");
		return colaboradorRepository.save(colaboradorAtual); 
	}
}
