package com.projeto.aprendizado.infraestrutura.aluno.db;

import com.projeto.aprendizado.AprendizadoApplication;
import com.projeto.aprendizado.dominio.aluno.Aluno;
import com.projeto.aprendizado.dominio.aluno.AlunoNaoEncontrado;
import com.projeto.aprendizado.dominio.utils.CPF;
import com.projeto.aprendizado.dominio.utils.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

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

    @Test
    void testeAtualizar() {
        //Dado um aluno matriculado
        Aluno aluno = Aluno.builder()
                .email(new Email("email@email.com"))
                .cpf(new CPF("111.111.111-11"))
                .nome("Fulano")
                .build();
        repository.matricular(aluno);

        //E eu queira trocar o email
        Aluno alunoSalvo = repository.buscarPorCPF(new CPF("111.111.111-11"));
        Aluno alunoAtual = Aluno.builder()
                .email(new Email("emailTrocado@email.com"))
                .cpf(new CPF(alunoSalvo.getCpf()))
                .nome(alunoSalvo.getNome())
                .build();
        alunoAtual.adicionarTelefone("77","77777777");

        //Quando eu atualizar o email
        repository.atualizarAluno(alunoAtual);

        //Então espero que tenha atualizado o email
        Aluno alunoAtualizado = repository.buscarPorCPF(new CPF("111.111.111-11"));
        assertEquals("emailTrocado@email.com", alunoAtualizado.getEmail());
        assertEquals("77", alunoAtualizado.getTelefones().get(0).getDdd());
        assertEquals("77777777", alunoAtualizado.getTelefones().get(0).getNumero());
    }

    @Test
    void testeApagar() {
        //Dado um aluno matriculado
        Aluno aluno = Aluno.builder()
                .email(new Email("email@email.com"))
                .cpf(new CPF("111.111.111-11"))
                .nome("Fulano")
                .build();
        repository.matricular(aluno);

        //Quando eu apagar
        repository.apagarAluno(aluno);

        //Então espero que tenha apagado os dados desse aluno
        Assertions.assertThrows(AlunoNaoEncontrado.class, () -> repository.buscarPorCPF(new CPF("111.111.111-11")));
    }

    @Test
    void testeBuscaTodos() {
        //Dado um aluno matriculado
        Aluno aluno = Aluno.builder()
                .email(new Email("email@email.com"))
                .cpf(new CPF("111.111.111-11"))
                .nome("Fulano")
                .build();
        repository.matricular(aluno);

        //Quando eu apagar
        List<Aluno> alunos = repository.listarTodosAlunosMatriculados();

        //Então espero que tenha um aluno cadastrado
        assertEquals(1, alunos.size());
    }
}
