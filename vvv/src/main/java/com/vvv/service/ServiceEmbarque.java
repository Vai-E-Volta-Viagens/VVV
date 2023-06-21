package com.vvv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vvv.model.Embarque;
import com.vvv.model.Proprietaria;
import com.vvv.repository.RepositoryEmbarque;


@Service
public class ServiceEmbarque {
	@Autowired
	private RepositoryEmbarque repositoryEmbarque;
	
	public Embarque save(Embarque embarque) {
		return repositoryEmbarque.save(embarque);
	}
	
	public List<Embarque> buscarEmbarquesDaProprietaria(Proprietaria proprietaria) {
	    return repositoryEmbarque.findByProprietaria(proprietaria);
	}
}