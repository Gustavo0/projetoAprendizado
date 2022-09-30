package com.projeto.aprendizado.aplicacao.aluno.matricular;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.CPF;
import com.projeto.aprendizado.dominio.aluno.Email;
import com.projeto.aprendizado.dominio.aluno.validation.DadosAlunoValidation;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@DadosAlunoValidation
public class MatricularAlunoDto {

	@NotEmpty
	private String nomeAluno;

	@NotEmpty
	private String cpfAluno;

	@NotEmpty
	private String emailAluno;
	
	public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
	}

	public Aluno criarAluno() {
		return Aluno.builder()
				.cpf(new CPF(cpfAluno))
				.nome(nomeAluno)
				.email(new Email(emailAluno))
				.build();
	}
	
}
