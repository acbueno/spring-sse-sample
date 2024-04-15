package br.com.acbueno.event.service.parse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Main {

  @JsonProperty("temp")
  private Double temp;

  @JsonProperty("temp_min")
  private Double temp_min;

  @JsonProperty("temp_max")
  private Double temp_max;

  @JsonProperty("humidity")
  private Integer humidity;

}
