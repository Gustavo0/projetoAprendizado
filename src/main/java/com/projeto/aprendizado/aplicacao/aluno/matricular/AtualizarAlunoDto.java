package com.projeto.aprendizado.aplicacao.aluno.matricular;

import lombok.Getter;

@Getter
public class AtualizarAlunoDto {

	private String cpfAluno;
	private String emailAluno;

	public AtualizarAlunoDto(String cpfAluno, String emailAluno) {
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
	}
	
}
