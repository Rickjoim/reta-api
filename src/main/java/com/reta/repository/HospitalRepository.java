package com.reta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reta.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
}
