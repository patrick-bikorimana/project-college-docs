package be.ephec.project_college_docs.exceptions;

public class ApiException extends RuntimeException{
    public ApiException (String message){
        super(message);
    }

    public ApiException(){
        super("An Error occurred!");
    }
}
