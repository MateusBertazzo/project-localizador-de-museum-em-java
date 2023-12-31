package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Museum controller class.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  MuseumServiceInterface museumService;


  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }

  /**
   * Route to create a new Museum.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Museum createMuseum(@RequestBody MuseumCreationDto museumDtoCreation) {
    Museum museum = ModelDtoConverter.dtoToModel(museumDtoCreation);

    return museumService.createMuseum(museum);
  }

  /**
   * Route to get the closest museum.
   */
  @GetMapping("/closest")
  @ResponseStatus(HttpStatus.OK)
  public MuseumDto getClosestMuseum(
      @RequestParam double lat, 
      @RequestParam double lng, 
      @RequestParam("max_dist_km") double maxDistKm) {
    Coordinate coordinate = new Coordinate(lat, lng);
    Museum museum = museumService.getClosestMuseum(coordinate, maxDistKm);

    MuseumDto museumConverter = ModelDtoConverter.modelToDto(museum);

    return museumConverter;
  }


  /**
   * Route to get a museum by id.
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public MuseumDto getMuseum(@RequestParam Long id) {
    Museum museum = museumService.getMuseum(id);

    MuseumDto museumConverter = ModelDtoConverter.modelToDto(museum);

    return museumConverter;
  }
}
