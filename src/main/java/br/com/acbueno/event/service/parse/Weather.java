package br.com.acbueno.event.service.parse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weather {

  @JsonProperty("description")
  private String description;


}
