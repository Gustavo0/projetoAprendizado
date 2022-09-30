package com.projeto.aprendizado.dominio.aluno.validation;

import com.projeto.aprendizado.aplicacao.advice.FieldMessage;
import com.projeto.aprendizado.aplicacao.aluno.matricular.MatricularAlunoDto;
import com.projeto.aprendizado.dominio.utils.CPF;
import com.projeto.aprendizado.dominio.utils.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class DadosAlunoValidator implements ConstraintValidator<DadosAlunoValidation, MatricularAlunoDto> {

	@Override
	public boolean isValid(MatricularAlunoDto objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(!CPF.isValid(objDto.getCpfAluno())) {
			list.add(new FieldMessage("cpfAluno", "CPF inválido"));
		}

		if(!Email.isValid(objDto.getEmailAluno())) {
			list.add(new FieldMessage("emailAluno", "Email inválido"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
