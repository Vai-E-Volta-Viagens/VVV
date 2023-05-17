package com.vvv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "tb_modal")
public class Modal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_modal")
	private Long idModal;
	
	@Column(name = "tipo_modal", nullable = false)
	private String tipoModal;
	
	
	public Modal() {}
	public Modal(Long idModal, String tipoModal) {
		this.idModal = idModal;
		this.tipoModal = tipoModal;
	}
}
