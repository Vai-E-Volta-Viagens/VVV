package com.vvv.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import com.vvv.model.Cartao;
import com.vvv.repository.RepositoryCartao;
import jakarta.transaction.Transactional;

@Service
public class ServiceCartao {
	@Autowired
	private RepositoryCartao repositoryCartao;
	
	public void save(Cartao cartao) {
		repositoryCartao.save(cartao);
	}
	
	public Optional<Cartao> findByIdCartao(Long idCartao){
		return repositoryCartao.findById(idCartao);
	}
	
	@Transactional
	@Modifying
	public void delete(Long id) {
		repositoryCartao.deleteById(id);
	}
}
