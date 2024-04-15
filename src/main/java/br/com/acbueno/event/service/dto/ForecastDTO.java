package br.com.acbueno.event.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForecastDTO {

  @JsonProperty("city")
  private String city;

  @JsonProperty("description")
  private String description;

  @JsonProperty("current-temp")
  private Double currentTemp;

  @JsonProperty("temp-min")
  private Double tempMin;

  @JsonProperty("temp-max")
  private Double tempMax;

  @JsonProperty("win-speed")
  private Double windSpeed;

  @JsonProperty("sunrise")
  private String sunrise;

  @JsonProperty("sunset")
  private String sunset;

}
