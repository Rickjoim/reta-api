package com.reta.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reta.model.Hospital;
import com.reta.repository.HospitalRepository;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public HospitalController(HospitalRepository HospitalRepository){
		this.hospitalRepository = HospitalRepository;
	}
	
	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Hospital> listar() {
		return hospitalRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Hospital findById(@PathVariable("id") Long id){
		var HospitalVar = hospitalRepository.getById(id);
		return Hospital.converter(HospitalVar); 
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public Hospital adicionar(@RequestBody Hospital Hospital) {
		return hospitalRepository.save(Hospital);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Hospital atualizar(@PathVariable Long id, @RequestBody Hospital Hospital){
		Hospital hospitalAtual = hospitalRepository.findById(id).get();
		BeanUtils.copyProperties(Hospital, hospitalAtual, "id");
		return hospitalRepository.save(hospitalAtual); 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN')")
	public void exluir(@PathVariable Long id) {
		hospitalRepository.deleteById(id);
	}
	
}
