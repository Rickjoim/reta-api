package com.reta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.reta.model.UserReta;
import com.reta.repository.UserRepository;


@Component
public class CustomUserDetailService implements UserDetailsService{
	private final UserRepository userRepository;
	
	@Autowired
	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		UserReta userReta = Optional.ofNullable( userRepository.findByUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		return new org.springframework.security.core.userdetails.User(userReta.getUsername(), userReta.getPassword(), userReta.isTipo() == '1' ? authorityListAdmin : authorityListUser);
	}
}
