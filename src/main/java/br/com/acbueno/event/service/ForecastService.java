package br.com.acbueno.event.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.acbueno.event.service.dto.ForecastDTO;
import br.com.acbueno.event.service.parse.Forecast;
import br.com.acbueno.event.service.parse.Weather;

@Service
public class ForecastService {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.url}")
  private String apiUrl;

  @Value("${api.lat}")
  private Double lat;

  @Value("${api.lon}")
  private Double lon;

  @Value("${api.id}")
  private String appId;

  @Value("${api.lang}")
  private String codeLang;

  @Value("${unit.code}")
  private String unitCode;

  private Weather weather;


  private Forecast getDataFromApi() {
    //@formatter:off
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromUriString(apiUrl)
            .queryParam("lat", lat)
            .queryParam("lon", lon)
            .queryParam("appId", appId)
            .queryParam("lang", codeLang)
            .queryParam("units", unitCode);
    String url = builder.toUriString();
    //@formatter:on
    return restTemplate.getForObject(url, Forecast.class);
  }

  public ForecastDTO getForecast() {
    Forecast dataFromApi = getDataFromApi();
    weather = dataFromApi.getWeather().get(0);
    String hourSunrise = convertDateTime(dataFromApi.getSys().getSunrise());
    String hourSunset = convertDateTime(dataFromApi.getSys().getSunset());

    return createForecastDTO(dataFromApi, hourSunrise, hourSunset);
  }

  private ForecastDTO createForecastDTO(Forecast dataFromApi, String hourSunrise,
      String hourSunset) {
    //@formatter:off
    ForecastDTO forecastDTO = ForecastDTO.builder()
        .city(dataFromApi.getName())
        .description(weather.getDescription())
        .currentTemp(dataFromApi.getMain().getTemp())
        .tempMin(dataFromApi.getMain().getTemp_min())
        .tempMax(dataFromApi.getMain().getTemp_max())
        .windSpeed(dataFromApi.getWind().getSpeed())
        .sunrise(hourSunrise)
        .sunset(hourSunset)
        .build();
    //@formatter:on
    return forecastDTO;
  }

  private String convertDateTime(Long time) {
    // Timestamp ts = new Timestamp(time);
    Instant instant = Instant.ofEpochSecond(time);
    LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy ");
    String formattedDateTime = localDateTime.format(formatter);
    return formattedDateTime;
  }
}
