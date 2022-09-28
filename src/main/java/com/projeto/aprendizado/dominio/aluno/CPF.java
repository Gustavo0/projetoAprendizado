package com.projeto.aprendizado.dominio.aluno;

import lombok.Builder;

@Builder
public class CPF {

	private String numero;

	public CPF(String numero) {
		if (numero == null || 
				!numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("CPF invalido!");
		}
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
}
