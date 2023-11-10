package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateValidationUtilException;
import org.springframework.stereotype.Service;


/**
 * Service MuseumService.
 */
@Service
public class MuseumService implements MuseumServiceInterface {
  private MuseumFakeDatabase museumFakeDatabase;

  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    double latitude = museum.getCoordinate().latitude();
    double longitude = museum.getCoordinate().longitude();

    CoordinateValidationUtilException.validateCoordinate(latitude, longitude);
    return museumFakeDatabase.saveMuseum(museum);
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    double latitude = coordinate.latitude();
    double longitude = coordinate.longitude();
      
    CoordinateValidationUtilException.validateCoordinate(latitude, longitude);

    return museumFakeDatabase.getClosestMuseum(coordinate, maxDistance)
        .orElseThrow(() -> new MuseumNotFoundException());
  }

  @Override
  public Museum getMuseum(Long id) {
    return museumFakeDatabase.getMuseum(id)
        .orElseThrow(() -> new MuseumNotFoundException());
  }
}
