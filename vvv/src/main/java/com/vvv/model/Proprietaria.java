package com.vvv.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_proprietaria")
public class Proprietaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proprietaria")
	private Long idProprietaria;
	
	@OneToMany(mappedBy="fkProprietaria", fetch = FetchType.EAGER)
	private List<Pagamento> pagamento;
	
	@OneToMany(mappedBy="fkProprietaria")
	private List<Embarque> embarque;
	
	@Column(name = "name_proprietaria", nullable = false, length = 100)
	private String nomeProprietaria;
	
	@Column(name = "cnpj_proprietaria", nullable = false, length = 14)
	private Long cnpjProprietaria;
}
