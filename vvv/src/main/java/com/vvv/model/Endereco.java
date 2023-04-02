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
@Table(name = "tb_endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long idEndereco;
	
	@Column(name = "rua", nullable = false, length = 40)
	private String rua;
	
	@Column(name = "numero", nullable = false, length = 10)
	private String numero;
	
	@Column(name = "cidade", nullable = false, length = 40)
	private String cidade;
	
	@Column(name = "estado", nullable = false, length = 40)
	private String estado;
	
	@Column(name = "uf", nullable = false, length = 2)
	private String uf;
	
	@Column(name = "cep", nullable = false, length = 8)
	private Long cep;
	
	
	public Endereco() {}
	public Endereco(Long idEndereco, String rua, String numero, String cidade, String estado, String uf, Long cep) {
		this.idEndereco = idEndereco;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.uf = uf;
		this.cep = cep;
	}
}
