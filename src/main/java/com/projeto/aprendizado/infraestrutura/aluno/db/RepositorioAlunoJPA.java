package com.projeto.aprendizado.infraestrutura.aluno.db;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.AlunoNaoEncontrado;
import com.projeto.aprendizado.dominio.aluno.CPF;
import com.projeto.aprendizado.dominio.aluno.RepositorioDeAlunos;

import java.util.List;

public class RepositorioAlunoJPA implements RepositorioDeAlunos {

    private AlunoRepository repository;
    private AlunoConverter converter;

    public RepositorioAlunoJPA(AlunoRepository repository, AlunoConverter converter){
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public void matricular(Aluno aluno) {
        repository.save(converter.toAlunoEntity(aluno));
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        AlunoEntity alunoEntity = repository.findById(cpf.getNumero())
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
        return converter.toAluno(alunoEntity);
    }

    @Override
    public void atualizarAluno(Aluno aluno) {
        repository.save(converter.toAlunoEntity(aluno));
    }

    @Override
    public void apagarAluno(Aluno aluno) {
        repository.delete(converter.toAlunoEntity(aluno));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        List<AlunoEntity> alunoEntities = repository.findAll();
        return converter.toAlunos(alunoEntities);
    }
}
