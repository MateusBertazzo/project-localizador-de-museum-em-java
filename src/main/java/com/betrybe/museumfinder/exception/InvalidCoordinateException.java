package com.betrybe.museumfinder.exception;

/**
 * Exception para coordinate invalid.
 */
public class InvalidCoordinateException extends RuntimeException {
  public InvalidCoordinateException(String messageError) {
    super(messageError);
  }
}
