package br.com.compassuol.sp.challenge.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class CPFAlreadyExistsException extends RuntimeException {
    public CPFAlreadyExistsException(String message) {
        super(message);
    }
}
