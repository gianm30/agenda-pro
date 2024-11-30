package com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String CLAVE_ERROR = "error";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handle(MethodArgumentNotValidException e) {
        List<String> errores = new ArrayList<>();
        for(FieldError error : e.getBindingResult().getFieldErrors())
            errores.add(error.getDefaultMessage());
        var rpta = errores.stream().collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(getError(rpta));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handle(RuntimeException e) {
        return ResponseEntity.badRequest().body(getError(e.getMessage()));
    }

    private <T> Map<String, T> getError(T datos) {
        return Collections.singletonMap(CLAVE_ERROR, datos);
    }
}