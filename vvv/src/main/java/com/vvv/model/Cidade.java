package com.vvv.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_cidade")
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade", unique = true)
	private Long IdCidade;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado")
	private Estado fkEstado;
	
	@OneToMany(mappedBy="fkCidade")
	private List<Endereco> endereco;
	
	@Column(name = "nome_cidade", nullable = false, length = 100)
	private String nomeCidade;
}
