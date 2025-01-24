package com.pacifico.demopacificogradle.controller;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderAsyncClient;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/messages")
public class MessageController {

  private final ServiceBusSenderAsyncClient senderClient;

  public MessageController(ServiceBusSenderAsyncClient senderClient) {
    this.senderClient = senderClient;
  }

  @PostMapping
  public Mono<ResponseEntity<String>> sendMessage(@RequestBody String message) {
    return senderClient.sendMessage(new ServiceBusMessage(message))
        .then(Mono.just(ResponseEntity.ok("Mensaje enviado con éxito")))
        .onErrorResume(e -> {
          e.printStackTrace(); // Registrar el error en logs
          return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("Error al enviar el mensaje: " + e.getMessage()));
        });
  }
}