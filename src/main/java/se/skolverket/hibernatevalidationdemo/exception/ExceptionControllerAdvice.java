package se.skolverket.hibernatevalidationdemo.exception;

import org.apache.catalina.util.ToStringUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    //hibernate validator method from ResponseEntityExceptionHandler
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> result = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
                String filedName = ((FieldError) error).getField();
                String message = error.getDefaultMessage();
                result.put(filedName,message);
        });
        System.out.println("Status -> " + status);
        System.out.println("request -> " + request.getParameterMap().values());
        return new ResponseEntity<>(result, status);
    }

    //handler for customised exception
    @ExceptionHandler(value = {CustomisedException.class})
    public ResponseEntity<Object> handleCustomisedException(CustomisedException e) {
        Map<String, String> error = new HashMap<>();
        error.put("error occurs", e.getMessage());
        System.out.println("message: -> " + e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
