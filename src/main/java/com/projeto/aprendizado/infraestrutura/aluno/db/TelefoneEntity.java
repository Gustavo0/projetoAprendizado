package com.projeto.aprendizado.infraestrutura.aluno.db;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Builder
@Getter
public class TelefoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="cpf")
	private AlunoEntity aluno;

	private String numero;

}
