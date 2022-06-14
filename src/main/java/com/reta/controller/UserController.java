package com.reta.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reta.model.UserReta;
import com.reta.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@GetMapping("/")
	public List<UserReta> listar() {
		return (List<UserReta>) userRepository.findAll();
	}
	
	//@GetMapping("/{id}")
	//public UserReta findById(@PathVariable("id") Long id){
	//	var userVar = userRepository.findById(id);
	//	return UserReta.converter(userVar); 
	//}
	
	
	@PostMapping
	public UserReta adicionar(@RequestBody UserReta userReta) {
		userRepository.save(userReta);
		userReta.setPassword(new BCryptPasswordEncoder().encode(userReta.getPassword()));
		return userRepository.save(userReta);
	}
	
	@PutMapping("/{id}")
	public UserReta atualizar(@PathVariable Long id, @RequestBody UserReta userReta){
		UserReta userAtual = userRepository.findById(id).get();
		BeanUtils.copyProperties(userReta, userAtual, "id");
		return userRepository.save(userAtual); 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void exluir(@PathVariable Long id) {
		userRepository.deleteById(id);
	}


}
