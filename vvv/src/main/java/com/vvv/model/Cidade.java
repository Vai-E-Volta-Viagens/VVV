package com.vvv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "tb_cidade")
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade", unique = true)
	private Long IdCidade;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado")
	private Estado estado;
	
	@Column(name = "nome_cidade", nullable = false, length = 100)
	private String nomeCidade;
	
	public Cidade() {}
	public Cidade(Long idCidade, Estado estado, String nomeCidade) {
		this.IdCidade = idCidade;
		this.estado = estado;
		this.nomeCidade = nomeCidade;
	};
}
