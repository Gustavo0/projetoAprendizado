package com.projeto.aprendizado.aplicacao.aluno;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.aprendizado.aplicacao.aluno.matricular.MatricularAluno;
import com.projeto.aprendizado.aplicacao.aluno.matricular.MatricularAlunoDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AlunoController.class)
@AutoConfigureMockMvc(addFilters = false)
class AlunoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private MatricularAluno matricularAluno;

    @Test
    void matricularAluno() throws Exception {
        MatricularAlunoDto aluno = MatricularAlunoDto.builder()
                .nomeAluno("Fulano")
                .emailAluno("email@email.com")
                .cpfAluno("111.111.111-11")
                .build();

        doNothing().when(matricularAluno).executa(aluno);

        mvc.perform(post("/aluno")
                .content(serializaEntrada(aluno))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    private byte[] serializaEntrada(MatricularAlunoDto aluno) throws JsonProcessingException {
        return new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .writeValueAsBytes(aluno);
    }
}
