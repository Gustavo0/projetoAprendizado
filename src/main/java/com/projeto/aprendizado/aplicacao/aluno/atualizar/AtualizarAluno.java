package com.projeto.aprendizado.aplicacao.aluno.atualizar;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.utils.CPF;
import com.projeto.aprendizado.dominio.aluno.interfaces.RepositorioDeAlunos;
import org.springframework.stereotype.Service;

@Service
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
