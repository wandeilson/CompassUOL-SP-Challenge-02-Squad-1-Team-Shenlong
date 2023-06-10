package br.com.compassuol.sp.challenge.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
