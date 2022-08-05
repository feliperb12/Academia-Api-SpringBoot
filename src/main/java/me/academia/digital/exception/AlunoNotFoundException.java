package me.academia.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(Long id) {
        super("Aluno not found with Id: " + id);
    }
}
