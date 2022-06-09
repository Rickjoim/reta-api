package com.reta.controller;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.reta.model.Oportunidade;
import com.reta.model.Solicitacao;
//import com.reta.repository.OportunidadeRepository;
import com.reta.repository.SolicitacaoRepository;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {

	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	
	public SolicitacaoController(SolicitacaoRepository solicitacaoRepository){
		this.solicitacaoRepository = solicitacaoRepository;
	}
	
	@GetMapping("/")
	public List<Solicitacao> listar() {
		return solicitacaoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Solicitacao findById(@PathVariable("id") Long id){
		var solicitacaoVar = solicitacaoRepository.getById(id);
		return Solicitacao.converter(solicitacaoVar); 
	}
	
	///*
	@GetMapping(value = "/buscarPorTema") //Busca por Tema ou partes
	@ResponseBody
	public ResponseEntity<List<Solicitacao>> buscarPorTema(@RequestParam(required=false,name="tema") String tema){
		List<Solicitacao> solicitacao = solicitacaoRepository.buscarPorTema(tema.trim());
		return new  ResponseEntity<List<Solicitacao>>(solicitacao, HttpStatus.OK); 
	}
	//*/
	
	@PostMapping
	public Solicitacao adicionar(@RequestBody Solicitacao solicitacao) {
		return solicitacaoRepository.save(solicitacao);
	}
	
	@PutMapping("/{id}")
	public Solicitacao atualizar(@PathVariable Long id, @RequestBody Solicitacao solicitacao){
		Solicitacao solicitacaoAtual = solicitacaoRepository.findById(id).get();
		BeanUtils.copyProperties(solicitacao, solicitacaoAtual, "id");
		return solicitacaoRepository.save(solicitacaoAtual); 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void exluir(@PathVariable Long id) {
		solicitacaoRepository.deleteById(id);
	}


}
