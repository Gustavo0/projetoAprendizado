package com.projeto.aprendizado.infraestrutura.aluno.db;

import com.projeto.aprendizado.AprendizadoApplication;
import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.CPF;
import com.projeto.aprendizado.dominio.aluno.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AprendizadoApplication.class)
class RepositorioAlunoJPATest {

    @Autowired
    private RepositorioAlunoJPA repository;

    @Test
    void testeSave() {
        //Dado um aluno para matricular
        Aluno aluno = Aluno.builder()
                .email(new Email("email@email.com"))
                .cpf(new CPF("111.111.111-11"))
                .nome("Fulano")
                .build();

        //Quando eu salvar a matrícula
        repository.matricular(aluno);

        //Então espero que tenha salvo
        Aluno alunoSalvo = repository.buscarPorCPF(new CPF("111.111.111-11"));
        assertEquals("Fulano", alunoSalvo.getNome());
    }
}
