package com.projeto.aprendizado.infraestrutura.aluno.db;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.CPF;
import com.projeto.aprendizado.dominio.aluno.Email;
import com.projeto.aprendizado.dominio.aluno.Telefone;

import java.util.ArrayList;
import java.util.List;

public class AlunoConverter {

    public List<AlunoEntity> toAlunosEntity(List<Aluno> alunos){
        List<AlunoEntity> alunosEntity = new ArrayList<>();
        for (Aluno aluno : alunos) {
            AlunoEntity alunoEntity = toAlunoEntity(aluno);
            alunosEntity.add(alunoEntity);
        }
        return alunosEntity;
    }

    public AlunoEntity toAlunoEntity(Aluno aluno){
        return AlunoEntity.builder()
                .cpf(aluno.getCpf())
                .email(aluno.getEmail())
                .nome(aluno.getNome())
                .senha(aluno.getSenha())
                .telefones(toTelefoneEntity(aluno.getTelefones()))
                .build();
    }

    private List<TelefoneEntity> toTelefoneEntity(List<Telefone> telefones) {
        List<TelefoneEntity> telefonesEntities = new ArrayList<>();
        for(Telefone telefone : telefones){
            telefonesEntities.add(TelefoneEntity.builder()
                    .numero(telefone.getDdd() + telefone.getNumero())
                    .build());
        }
        return telefonesEntities;
    }

    public List<Aluno> toAlunos(List<AlunoEntity> alunosEntity){
        List<Aluno> alunos = new ArrayList<>();
        for (AlunoEntity alunoEntity : alunosEntity) {
            Aluno aluno = toAluno(alunoEntity);
            alunos.add(aluno);
        }
        return alunos;
    }

    public Aluno toAluno(AlunoEntity entity){
        return Aluno.builder()
                .cpf(new CPF(entity.getCpf()))
                .email(new Email(entity.getEmail()))
                .nome(entity.getNome())
                .senha(entity.getSenha())
                .telefones(toTelefone(entity.getTelefones()))
                .build();
    }

    private List<Telefone> toTelefone(List<TelefoneEntity> telefonesEntities) {
        List<Telefone> telefones = new ArrayList<>();
        for(TelefoneEntity telefone : telefonesEntities){
            telefones.add(Telefone.builder()
                    .ddd(telefone.getNumero().substring(0,2))
                    .numero(telefone.getNumero().substring(3))
                    .build());
        }
        return telefones;
    }
}
