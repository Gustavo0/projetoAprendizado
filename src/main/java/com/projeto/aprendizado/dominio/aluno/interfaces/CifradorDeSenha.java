package com.projeto.aprendizado.dominio.aluno.interfaces;

public interface CifradorDeSenha {

	String cifrarSenha(String senha);
	
	boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
