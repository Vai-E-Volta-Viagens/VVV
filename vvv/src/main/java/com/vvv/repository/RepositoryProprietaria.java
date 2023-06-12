package com.vvv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vvv.model.Embarque;


public interface RepositoryProprietaria extends JpaRepository<Embarque, Long>{
	
}
