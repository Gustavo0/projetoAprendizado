package com.projeto.aprendizado.aplicacao.aluno.apagar;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.CPF;
import com.projeto.aprendizado.dominio.aluno.RepositorioDeAlunos;

public class ApagarAluno {

    private final RepositorioDeAlunos repositorio;

    public ApagarAluno(RepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }

    public void executa(String cpf) {
        Aluno aluno = repositorio.buscarPorCPF(new CPF(cpf));
        repositorio.apagarAluno(aluno);
    }
}
