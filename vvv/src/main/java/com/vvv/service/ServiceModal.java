package com.vvv.service;

import java.util.Optional;

import com.vvv.model.Modal;
import com.vvv.repository.RepositoryModal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceModal {
	@Autowired
	private RepositoryModal repositoryModal;
	
	public Optional<Modal> findById(Long id){
		return repositoryModal.findById(id);
	}
}