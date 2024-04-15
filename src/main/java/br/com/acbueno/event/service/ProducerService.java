package br.com.acbueno.event.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import lombok.extern.java.Log;

@Service
@Log
public class ProducerService {

  @Autowired
  private ForecastService forecastService;

  private void getData(ResponseBodyEmitter emitter) {
    try {
      DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      LocalDateTime currentTime = LocalDateTime.now();
      emitter.send(String.format("Data: %s", forecastService.getForecast().toString()));
      log.info(String.format("Success: %s", dateTimeFormat.format(currentTime)));
    } catch (IOException e) {
      emitter.completeWithError(e);
      log.log(Level.SEVERE, e.getLocalizedMessage());
    }
  }

  public void start(SseEmitter emitter) {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
      mountData(emitter);
    }, 0, 20, TimeUnit.SECONDS);
    executor.schedule(() -> {
      future.cancel(false);
      executor.shutdown();
      log.info("Finished schedule");
    }, 1, TimeUnit.MINUTES);

  }

  public ResponseBodyEmitter mountData(SseEmitter emitter) {
    getData(emitter);
    return emitter;
  }

}
