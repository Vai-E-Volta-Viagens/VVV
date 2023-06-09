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
@Table(name = "tb_proprietaria")
public class Proprietaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proprietaria")
	private Long idProprietaria;
	
	@Column(name = "name_proprietaria", nullable = false, length = 100)
	private String nomeProprietaria;
	
	@Column(name = "cnpj_proprietaria", nullable = false, length = 14)
	private Long cnpjProprietaria;
	
	
	public Proprietaria() {}
	public Proprietaria(Long idProprietaria, String nomeProprietaria, Long cnpjProprietaria) {
		this.idProprietaria = idProprietaria;
		this.nomeProprietaria = nomeProprietaria;
		this.cnpjProprietaria = cnpjProprietaria;
	}
}
