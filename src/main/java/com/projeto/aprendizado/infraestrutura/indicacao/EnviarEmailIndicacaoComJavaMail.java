package com.projeto.aprendizado.infraestrutura.indicacao;

import com.projeto.aprendizado.aplicacao.indicacao.EnviarEmailIndicacao;
import com.projeto.aprendizado.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicado) {
		// logica de envio de email com a lib Java Mail
	}
}
