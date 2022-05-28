package com.reta.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.reta.model.UserReta;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserReta, Long>{
	UserReta findByUsername(String username);
}
