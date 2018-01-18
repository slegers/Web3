package model.domain.exceptions;

public class NotAuthorizedException extends RuntimeException{

    public NotAuthorizedException(String message){
        super(message);
    }

    public NotAuthorizedException(String message, Throwable exception){
        super(message,exception);
    }
}
