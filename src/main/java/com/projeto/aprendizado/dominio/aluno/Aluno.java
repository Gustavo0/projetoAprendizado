package com.projeto.aprendizado.dominio.aluno;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Aluno {
	
	private CPF cpf;
	private String nome;
	
	private Email email;

	private List<Telefone> telefones = new ArrayList<>();

	private String senha;

	public void adicionarTelefone(String ddd, String numero) {
		this.telefones.add(new Telefone(ddd, numero));
	}
	
	public String getCpf() {
		return cpf.getNumero();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email.getEndereco();
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public String getSenha() {
		return senha;
	}

	public void trocaEmail(String email){
		this.email = new Email(email);
	}
	
}






