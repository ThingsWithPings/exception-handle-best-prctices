package thins.with.pings.exceptionhandle.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import thins.with.pings.exceptionhandle.exception.ResourceCreationFailedException;
import thins.with.pings.exceptionhandle.response.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceCreationFailedException.class)
    public ResponseEntity<Response> resourceCreationFailedException(Exception e){
        Response response = new Response("FAILED", e.getMessage(),null);
        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
