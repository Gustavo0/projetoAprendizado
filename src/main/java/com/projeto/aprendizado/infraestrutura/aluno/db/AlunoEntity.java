package com.projeto.aprendizado.infraestrutura.aluno.db;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Builder
@Getter
public class AlunoEntity {

	@Id
	private String cpf;

	private String nome;

	private String email;

	@OneToMany(mappedBy="aluno")
	private List<TelefoneEntity> telefones;

	private String senha;

	public AlunoEntity(String cpf, String nome, String email, List<TelefoneEntity> telefones, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefones = telefones;
		this.senha = senha;
	}
	
}






