package med.voll.api.controller;

import com.auth0.jwt.exceptions.JWTCreationException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratadorErros() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EntityTypeException.class)
    public ResponseEntity tratadorErrosType(EntityTypeException e) {
        var errors = e.getCause();
        return ResponseEntity.unprocessableEntity().body(errors);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity tratadorErrosType(EntityExistsException e) {
        var errors = e.getCause();
        return ResponseEntity.unprocessableEntity().body(errors);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratadorErros400(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity tratadorErrosIllegalArgs(IllegalArgumentException e) {
        var errors = e.getCause();
        return ResponseEntity.unprocessableEntity().body(errors);
    }

    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity tratadorErros500(JWTCreationException e) {
        var errors = e.getCause();
        return ResponseEntity.internalServerError().body(errors);
    }
}