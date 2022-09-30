package com.projeto.aprendizado.dominio.aluno;

import lombok.Builder;

@Builder
public class CPF {

	private String numero;

	public CPF(String numero) {
		if (!isValid(numero)) {
			throw new IllegalArgumentException("CPF invalido!");
		}
		this.numero = numero;
	}

	public static boolean isValid(String numero) {
		return numero != null &&
				numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
	}

	public String getNumero() {
		return numero;
	}
	
}
