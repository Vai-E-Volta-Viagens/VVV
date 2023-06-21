package com.vvv.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tb_estado")
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado", unique = true)
	private Long idEstado;
	
	@OneToMany(mappedBy="fkEstado")
	private List<Cidade> cidade;
	
	@Column(name = "nome_estado", nullable = false, length = 100)
	private String nomeEstado;
	
	@Column(name = "uf_estado", nullable = false, length = 2)
	private String uf;
}