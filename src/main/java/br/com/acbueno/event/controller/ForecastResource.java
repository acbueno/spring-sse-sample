package br.com.acbueno.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.event.service.ForecastService;
import br.com.acbueno.event.service.dto.ForecastDTO;

@RestController("/forecast")
public class ForecastResource {

  @Autowired
  private ForecastService forecastService;

  @GetMapping("/data")
  public ResponseEntity<ForecastDTO> getData() {
    return ResponseEntity.ok(forecastService.getForecast());
  }
}
