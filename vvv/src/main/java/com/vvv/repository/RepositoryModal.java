package com.vvv.repository;

import java.util.Optional;
import com.vvv.model.Modal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryModal extends JpaRepository<Modal, Long>{
	Optional<Modal> findById(Long id);
}
