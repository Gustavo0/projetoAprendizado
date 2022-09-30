package com.projeto.aprendizado.infraestrutura.aluno.db;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
public class AlunoEntity {

	@Id
	private String cpf;

	private String nome;

	private String email;

	@OneToMany(mappedBy="aluno", fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	private List<TelefoneEntity> telefones;

	private String senha;

	public AlunoEntity(){}

	public AlunoEntity(String cpf, String nome, String email, List<TelefoneEntity> telefones, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefones = telefones;
		this.senha = senha;
	}
	
}






