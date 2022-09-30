package com.projeto.aprendizado.aplicacao.aluno;

import com.projeto.aprendizado.aplicacao.aluno.matricular.MatricularAluno;
import com.projeto.aprendizado.aplicacao.aluno.matricular.MatricularAlunoDto;
import com.projeto.aprendizado.infraestrutura.aluno.db.RepositorioDeAlunosEmMemoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private MatricularAluno matricularAluno;

    @PostMapping
    ResponseEntity<String> matricular(@RequestBody @Valid MatricularAlunoDto matricularAlunoDto){
        matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        matricularAluno.executa(matricularAlunoDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{cpf}").buildAndExpand(matricularAlunoDto.getCpfAluno()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
