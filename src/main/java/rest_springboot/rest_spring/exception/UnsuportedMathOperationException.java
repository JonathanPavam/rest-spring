package rest_springboot.rest_spring.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException {
    public UnsuportedMathOperationException(String message) {
        super(message);
    }
}
