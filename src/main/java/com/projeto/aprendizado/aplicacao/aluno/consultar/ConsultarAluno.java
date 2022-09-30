package com.projeto.aprendizado.aplicacao.aluno.consultar;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.CPF;
import com.projeto.aprendizado.dominio.aluno.RepositorioDeAlunos;
import org.springframework.stereotype.Service;

@Service
public class ConsultarAluno {

    private final RepositorioDeAlunos repositorio;

    public ConsultarAluno(RepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }

    public Aluno executa(String cpf) {
        return repositorio.buscarPorCPF(new CPF(cpf));
    }
}
