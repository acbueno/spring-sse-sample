package br.com.acbueno.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import br.com.acbueno.event.service.ProducerService;

@RestController("/sse")
public class ProducerSseController {

  @Autowired
  ProducerService producerService;

  @GetMapping("/events/start")
  public SseEmitter startStream() {
    SseEmitter emitter = new SseEmitter();
    producerService.start(emitter);
    return emitter;
  }

}
