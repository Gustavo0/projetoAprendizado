package com.projeto.aprendizado.infraestrutura.aluno.db;

import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.Telefone;
import com.projeto.aprendizado.dominio.utils.CPF;
import com.projeto.aprendizado.dominio.utils.Email;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlunoConverterTest {

    private AlunoConverter converter = new AlunoConverter();

    @Test
    void converterAlunoToEntity(){
        //Dado um Aluno
        List<Aluno> alunos = Arrays.asList(Aluno.builder()
                                            .nome("Fulano")
                                            .cpf(new CPF("111.111.111-11"))
                                            .email(new Email("email@email.com"))
                                            .telefones(Arrays.asList(new Telefone("11", "11111111"),
                                                    new Telefone("22", "22222222")))
                                            .build(),
                                            Aluno.builder()
                                                    .nome("Fulano2")
                                                    .cpf(new CPF("333.333.333-33"))
                                                    .email(new Email("email2@email.com"))
                                                    .telefones(Arrays.asList(new Telefone("33", "33333333"),
                                                            new Telefone("44", "44444444")))
                                                    .build());

        //Quando eu converter para entity
        List<AlunoEntity> alunoEntities = converter.toAlunosEntity(alunos);

        //Então espero que tenha convertido
        assertEquals(2, alunoEntities.size());
        assertEquals("Fulano", alunoEntities.get(0).getNome());
        assertEquals("Fulano2", alunoEntities.get(1).getNome());
    }

    @Test
    void converterAlunoEntityToAluno(){
        //Dado um AlunoEntity
        List<AlunoEntity> alunosEntities = Arrays.asList(AlunoEntity.builder()
                        .nome("Fulano")
                        .cpf("111.111.111-11")
                        .email("email@email.com")
                        .telefones(Arrays.asList(TelefoneEntity.builder().numero("9911111111").build(),
                                TelefoneEntity.builder().numero("2222222222").build()))
                        .build(),
                AlunoEntity.builder()
                        .nome("Fulano2")
                        .cpf("333.333.333-33")
                        .email("email2@email.com")
                        .telefones(Arrays.asList(TelefoneEntity.builder().numero("3333333333").build(),
                                TelefoneEntity.builder().numero("4444444444").build()))
                        .senha("senha")
                        .build());

        //Quando eu converter para entity
        List<Aluno> alunos = converter.toAlunos(alunosEntities);

        //Então espero que tenha convertido
        assertEquals(2, alunos.size());
        assertEquals("Fulano", alunos.get(0).getNome());
        assertEquals("Fulano2", alunos.get(1).getNome());
        assertEquals("333.333.333-33", alunos.get(1).getCpf());
        assertEquals("email2@email.com", alunos.get(1).getEmail());
        assertEquals("senha", alunos.get(1).getSenha());
    }
}
