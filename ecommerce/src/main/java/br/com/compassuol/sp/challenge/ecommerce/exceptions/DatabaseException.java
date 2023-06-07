package br.com.compassuol.sp.challenge.ecommerce.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String msg) {
        super(msg);
    }
}
