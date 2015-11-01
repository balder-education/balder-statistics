package br.com.baldereducation.baldersatistics.exception;

/**
 * This exception is thrown when the requested todo entry is not found.
 * 
 * @author Rogério Fontes
 */
public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -5944720271893372224L;

    public StudentNotFoundException(String id) {
        super(String.format("No todo entry found with id: <%s>", id));
    }
}
