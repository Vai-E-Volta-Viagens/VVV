package com.vvv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_cartao")
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cartao", unique = true)
	private Long idCartao;
	
	@Column(name = "tipo_cartao", length = 8)
	private String tipoCartao;
	
	@Column(name = "operadora", length = 50)
	private String operadora;
	
	@Column(name = "senha")
	private Long senha;
}
