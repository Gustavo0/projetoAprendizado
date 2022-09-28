package com.projeto.aprendizado.dominio.aluno;

public class FabricaDeAluno {
	
	private Aluno aluno;

	public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
		this.aluno = Aluno.builder()
				.cpf(new CPF(cpf))
				.nome(nome)
				.email(new Email(email))
				.build();
		return this;
	}
	
	public FabricaDeAluno comTelefone(String ddd, String numero) {
		this.aluno.adicionarTelefone(ddd, numero);
		return this;
	}
	
	public Aluno criar() {
		return this.aluno;
	}
	
}
