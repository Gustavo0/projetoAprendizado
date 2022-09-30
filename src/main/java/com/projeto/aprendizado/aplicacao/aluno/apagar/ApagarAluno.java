package com.projeto.aprendizado.aplicacao.aluno.apagar;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.utils.CPF;
import com.projeto.aprendizado.dominio.aluno.interfaces.RepositorioDeAlunos;
import org.springframework.stereotype.Service;

@Service
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
