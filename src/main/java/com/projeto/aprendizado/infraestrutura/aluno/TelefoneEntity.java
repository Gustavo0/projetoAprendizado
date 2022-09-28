package com.projeto.aprendizado.infraestrutura.aluno;

import javax.persistence.*;

@Entity
public class TelefoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="cpf")
	private AlunoEntity aluno;

	private String numero;

}
