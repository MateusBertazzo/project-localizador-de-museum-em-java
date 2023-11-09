package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public Museum createMuseum(@RequestBody MuseumDto museumDto) {
    Museum museum = ModelDtoConverter.dtoToModel(museumDto);

    return museumService.createMuseum(museum);
  }
}
