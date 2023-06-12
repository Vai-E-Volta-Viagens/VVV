package com.vvv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_endereco") // Tabela Endereco responsável por salvar os dados de Endereco
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco", unique = true)
	private Long idEndereco;
	
	@ManyToOne
	@JoinColumn(name = "fk_cidade")
	private Cidade fkCidade;
	
	@Column(name = "rua", nullable = false, length = 40)
	private String rua;
	
	@Column(name = "numero", nullable = false, length = 10)
	private String numero;
	
	@Column(name = "cep", nullable = false, length = 8)
	private Long cep;
	
	@Column(name = "complemento", length = 50)
	private String complemento;
}