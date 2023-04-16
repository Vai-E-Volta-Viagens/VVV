package com.vvv.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_passageiro") // Tabela Passageiro responsável por salvar os dados de Passageiro
public class Passageiro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_passageiro", unique = true)
	private Long idPassageiro;
	
	@Column(name = "codigo_passageiro", unique = true)
	private Long codigoPassageiro;
	
	@ManyToOne
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;
	
	@Column(name = "cpf_passageiro", nullable = false, unique = true, length = 11)
	private Long cpfPassageiro;
	
	@Column(name = "telefone_passageiro", nullable = false, unique = true, length = 14)
	private Long telefonePassageiro;
	
	@Column(name = "profissao_passageiro", nullable = false, length = 50)
	private String profissaoPassageiro;
	
	@Column(name = "rg_passageiro", nullable = false, length = 9)
	private Long rgPassageiro;
	
	@Column(name = "data_de_nascimento_passageiro", nullable = false)
	private LocalDate dataDeNascimentoPassageiro;
	
	@Column(name = "nacionalidade_passageiro", nullable = false, length = 30)
	private String nacionalidadePassageiro;
	
	@Column(name = "sexo_passageiro", nullable = false, length = 20)
	private String sexoPassageiro;

	
	public Passageiro() {}
	public Passageiro(Long idPassageiro, Long codigoPassageiro, Endereco endereco, Long cpfPassageiro, 
			Long telefonePassageiro, String profissaoPassageiro, Long rgPassageiro, LocalDate dataDeNascimentoPassageiro, 
			String nacionalidadePassageiro, String sexoPassageiro) {
		super();
		this.idPassageiro = idPassageiro;
		this.codigoPassageiro = codigoPassageiro;
		this.endereco = endereco;
		this.cpfPassageiro = cpfPassageiro;
		this.telefonePassageiro = telefonePassageiro;
		this.profissaoPassageiro = profissaoPassageiro;
		this.rgPassageiro = rgPassageiro;
		this.dataDeNascimentoPassageiro = dataDeNascimentoPassageiro;
		this.nacionalidadePassageiro = nacionalidadePassageiro;
		this.sexoPassageiro = sexoPassageiro;
	}
}





