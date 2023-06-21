package com.vvv.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vvv.model.PreCadastrado;
import com.vvv.repository.RepositoryPreCadastrado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Service
public class ServicePreCadastrado {
	@Autowired
	private RepositoryPreCadastrado repositoryPreCadastrado;
	
	public PreCadastrado save(PreCadastrado preCadastrado) {
		return repositoryPreCadastrado.save(preCadastrado);
	}
	
	public List<PreCadastrado> saveAll(List<PreCadastrado> preCadastrado){
		return repositoryPreCadastrado.saveAll(preCadastrado);
	}
	
	public Optional<PreCadastrado> findById(Long idPreCadastrado){
		return repositoryPreCadastrado.findById(idPreCadastrado);
	}
}	