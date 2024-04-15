package br.com.acbueno.event.service.parse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Sys {

  @JsonProperty("sunrise")
  private long sunrise;

  @JsonProperty("sunset")
  private long sunset;

}
