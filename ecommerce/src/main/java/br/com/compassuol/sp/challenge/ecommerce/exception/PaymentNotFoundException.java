package br.com.compassuol.sp.challenge.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PaymentNotFoundException extends Throwable {
    public PaymentNotFoundException(String s) {

            super(s);
        }
    }

