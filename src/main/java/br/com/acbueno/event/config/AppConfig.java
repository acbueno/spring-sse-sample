package br.com.acbueno.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

  @Bean
  public RestTemplate configRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getInterceptors()
        .add((ClientHttpRequestInterceptor) (request, body, execution) -> {
          return execution.execute(request, body);
        });
    return restTemplate;
  }

}
