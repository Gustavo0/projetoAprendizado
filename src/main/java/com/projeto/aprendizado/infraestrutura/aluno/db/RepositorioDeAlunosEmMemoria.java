package com.projeto.aprendizado.infraestrutura.aluno.db;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.AlunoNaoEncontrado;
import com.projeto.aprendizado.dominio.utils.CPF;
import com.projeto.aprendizado.dominio.aluno.interfaces.RepositorioDeAlunos;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

	private List<Aluno> matriculados = new ArrayList<>();
	
	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().equals(cpf.getNumero()))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEncontrado(cpf));
	}

	@Override
	public void atualizarAluno(Aluno aluno) {
		matriculados.remove(aluno);
		matriculados.add(aluno);
	}

	@Override
	public void apagarAluno(Aluno aluno) {
		matriculados.remove(aluno);
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		return this.matriculados;
	}

}
