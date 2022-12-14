package com.projeto.aprendizado.dominio.aluno.interfaces;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.utils.CPF;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDeAlunos {
	
	void matricular(Aluno aluno);
	
	Aluno buscarPorCPF(CPF cpf);

	void atualizarAluno(Aluno aluno);

	void apagarAluno(Aluno aluno);
	
	List<Aluno> listarTodosAlunosMatriculados();

}
