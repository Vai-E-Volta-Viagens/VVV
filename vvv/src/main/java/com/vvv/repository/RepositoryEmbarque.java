package com.vvv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vvv.model.Embarque;
import com.vvv.model.Proprietaria;

public interface RepositoryEmbarque extends JpaRepository<Embarque, Long>{
	@Query("SELECT e FROM Embarque e WHERE e.fkProprietaria = :proprietaria")
    List<Embarque> findByProprietaria(@Param("proprietaria") Proprietaria proprietaria);
}
