package com.projeto.aprendizado.dominio.aluno;

import java.util.List;

public interface RepositorioDeAlunos {
	
	void matricular(Aluno aluno);
	
	Aluno buscarPorCPF(CPF cpf);

	void atualizarAluno(Aluno aluno);
	
	List<Aluno> listarTodosAlunosMatriculados();
	
	//...

}
