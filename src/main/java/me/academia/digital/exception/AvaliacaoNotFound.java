package me.academia.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AvaliacaoNotFound extends RuntimeException {
    public AvaliacaoNotFound(Long id) {
        super("Avaliação not Found: " + id);
    }
}
