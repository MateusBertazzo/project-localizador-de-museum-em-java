package com.betrybe.museumfinder.util;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;


/**
 * Class to contain methods for coordinate validation.
 */
public class CoordinateValidationUtilException {
  
  /**
   * Method to validate a coordinate.
   */
  public static void validateCoordinate(double latitude, double longitude) {
    Coordinate coordinate = new Coordinate(latitude, longitude);

    if (!CoordinateUtil.isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException();
    }
  }
}

