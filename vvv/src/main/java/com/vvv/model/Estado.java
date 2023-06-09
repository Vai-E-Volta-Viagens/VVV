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
@Table(name = "tb_estado")
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado", unique = true)
	private Long idEstado;
	
	@Column(name = "nome_estado", nullable = false, length = 100)
	private String nomeEstado;
	
	@Column(name = "uf_estado", nullable = false, length = 2)
	private String uf;
	
	public Estado() {}
	public Estado(Long idEstado, String nomeEstado, String uf) {
		this.idEstado = idEstado;
		this.nomeEstado = nomeEstado;
		this.uf = uf;
	};
}
