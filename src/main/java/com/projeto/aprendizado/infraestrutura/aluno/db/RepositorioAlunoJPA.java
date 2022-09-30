package com.projeto.aprendizado.infraestrutura.aluno.db;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.AlunoNaoEncontrado;
import com.projeto.aprendizado.dominio.utils.CPF;
import com.projeto.aprendizado.dominio.aluno.interfaces.RepositorioDeAlunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class RepositorioAlunoJPA implements RepositorioDeAlunos {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoConverter converter;

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
