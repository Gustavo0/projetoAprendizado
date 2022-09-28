package com.projeto.aprendizado.aplicacao.aluno.apagar;

import com.projeto.aprendizado.aplicacao.aluno.matricular.MatricularAluno;
import com.projeto.aprendizado.aplicacao.aluno.matricular.MatricularAlunoDto;
import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.AlunoNaoEncontrado;
import com.projeto.aprendizado.dominio.aluno.CPF;
import com.projeto.aprendizado.infraestrutura.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApagarAlunoTest {

	private RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
	private MatricularAluno useCase = new MatricularAluno(repositorio);
	private ApagarAluno useCaseApagar = new ApagarAluno(repositorio);

	@BeforeEach
	void init(){
		MatricularAlunoDto dados = new MatricularAlunoDto(
				"Fulano",
				"123.456.789-00",
				"fulano@email.com");
		useCase.executa(dados);
	}

	@Test
	void alunoDeveriaSerApagado() {
		//Dado um aluno cadastrado
		Aluno aluno = repositorio.buscarPorCPF(new CPF("123.456.789-00"));
		assertEquals("123.456.789-00", aluno.getCpf());

		//Quando eu apaga-lo
		useCaseApagar.executa("123.456.789-00");

		//Então espero que tenha excluido
		//E quando eu buscar levante exceção de AlunoNaoEncontrado
		assertThrows(AlunoNaoEncontrado.class, () -> repositorio.buscarPorCPF(new CPF("123.456.789-00")));

	}

}
