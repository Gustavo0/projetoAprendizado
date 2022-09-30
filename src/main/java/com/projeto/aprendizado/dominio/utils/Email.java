package com.projeto.aprendizado.dominio.utils;

import lombok.Builder;

@Builder
public class Email {
	
	private String endereco;

	public Email(String endereco) {
		if (!isValid(endereco)) {
			throw new IllegalArgumentException("E-mail invalido!");
		}

		this.endereco = endereco;
	}

	public static boolean isValid(String endereco) {
		return endereco != null &&
				endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
	}

	public String getEndereco() {
		return endereco;
	}

}
