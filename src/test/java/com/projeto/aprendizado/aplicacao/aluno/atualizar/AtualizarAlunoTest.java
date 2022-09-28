package com.projeto.aprendizado.aplicacao.aluno.atualizar;

import com.projeto.aprendizado.aplicacao.aluno.matricular.MatricularAluno;
import com.projeto.aprendizado.aplicacao.aluno.matricular.MatricularAlunoDto;
import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.CPF;
import com.projeto.aprendizado.infraestrutura.aluno.db.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AtualizarAlunoTest {

	private RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
	private MatricularAluno useCase = new MatricularAluno(repositorio);
	private AtualizarAluno useCaseAtualizar = new AtualizarAluno(repositorio);

	@BeforeEach
	void init(){
		MatricularAlunoDto dados = new MatricularAlunoDto(
				"Fulano",
				"123.456.789-00",
				"fulano@email.com");
		useCase.executa(dados);
	}

	@Test
	void alunoDeveriaSerAtualizado() {
		//Dado um aluno cadastrado
		//E um email novo
		AtualizarAlunoDto alunoAtualizado = new AtualizarAlunoDto("123.456.789-00", "fulanoNovo@email.com");

		//Quando eu atualizar o email
		useCaseAtualizar.executa(alunoAtualizado);

		//Então espero que tenha atualizado o email
		Aluno aluno = repositorio.buscarPorCPF(new CPF(alunoAtualizado.getCpfAluno()));

		assertNotEquals("fulano@email.com", aluno.getEmail());
		assertEquals("fulanoNovo@email.com", aluno.getEmail());

	}

}
