package com.reta.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import com.reta.model.Capacitacao;
import com.reta.repository.CapacitacaoRepository;

@RestController
@RequestMapping("/capacitacao")
public class CapacitacaoController {

	@Autowired
	private CapacitacaoRepository capacitacaoRepository;

	public CapacitacaoController(CapacitacaoRepository capacitacaoRepository){
		this.capacitacaoRepository = capacitacaoRepository;
	}

	@GetMapping("/")
	public List<Capacitacao> listar() {
		return capacitacaoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Capacitacao findById(@PathVariable("id") Long id){
		var capacitacaoVar = capacitacaoRepository.getById(id);
		return Capacitacao.converter(capacitacaoVar);
	}

	@GetMapping(value = "/buscarPorNome") //Busca por nome ou partes
	@ResponseBody
	public ResponseEntity<List<Capacitacao>> buscarPorNome(@RequestParam(required=false,name="nome") String nome){
		List<Capacitacao> capacitacao = capacitacaoRepository.buscarPorNome(nome.trim());
		return new  ResponseEntity<List<Capacitacao>>(capacitacao, HttpStatus.OK);
	}

	@PostMapping
	public Capacitacao adicionar(@RequestBody Capacitacao capacitacao) {
		return capacitacaoRepository.save(capacitacao);
	}

	@PutMapping("/{id}")
	public Capacitacao atualizar(@PathVariable Long id, @RequestBody Capacitacao capacitacao){
		Capacitacao capacitacaoAtual = capacitacaoRepository.findById(id).get();
		BeanUtils.copyProperties(capacitacao, capacitacaoAtual, "id");
		return capacitacaoRepository.save(capacitacaoAtual);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void exluir(@PathVariable Long id) {
		capacitacaoRepository.deleteById(id);
	}
}
