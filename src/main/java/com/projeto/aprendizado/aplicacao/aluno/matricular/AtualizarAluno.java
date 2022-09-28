package com.projeto.aprendizado.aplicacao.aluno.matricular;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.CPF;
import com.projeto.aprendizado.dominio.aluno.RepositorioDeAlunos;

public class AtualizarAluno {

    private final RepositorioDeAlunos repositorio;

    public AtualizarAluno(RepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }

    public void executa(AtualizarAlunoDto dados) {
        Aluno alunoAtualizado = repositorio.buscarPorCPF(new CPF(dados.getCpfAluno()));
        alunoAtualizado.trocaEmail(dados.getEmailAluno());
        repositorio.atualizarAluno(alunoAtualizado);
    }
}
