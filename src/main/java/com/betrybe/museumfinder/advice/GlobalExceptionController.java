package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Global exception controller class.
 */
@ControllerAdvice
public class GlobalExceptionController {


  /**
   * Handle InvalidCoordinateException.
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleInvalidCoordinateException(RuntimeException error) {
    String errorMessage = "Coordenada inválida!";

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
  }


  /**
   * Handle MuseumNotFoundException.
   */
  @ExceptionHandler(MuseumNotFoundException.class)
    public ResponseEntity<String> handleNotFoundExcepetion(RuntimeException error) {
    String errorMessage = "Museu não encontrado!";

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  }


  /**
   * Handle Exception.
   */
  @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleErrorInternal(Exception error) {
    String errorMessage = "Erro interno!";

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
  }
}
