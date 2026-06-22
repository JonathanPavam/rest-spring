package rest_springboot.rest_spring.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import rest_springboot.rest_spring.exception.ExceptionResponse;
import rest_springboot.rest_spring.exception.ResourceNotFoundException;
import java.util.Date;


@RestController
@ControllerAdvice
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> hendleAllException(Exception exception, WebRequest webRequest){
        ExceptionResponse response = new ExceptionResponse(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception exception, WebRequest webRequest){
            ExceptionResponse response = new ExceptionResponse(new Date(), exception.getMessage(), webRequest.getDescription(false));

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
}
