package com.eragapati.webclienterrorhandling.controller;

import com.eragapati.webclienterrorhandling.exception.custom.CustomClientException;
import com.eragapati.webclienterrorhandling.model.HelloWorldModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "clientUsingRetrive")
public class ClientUsingRetriveController {

    @GetMapping("success")
    public Mono<ResponseEntity<HelloWorldModel>> sayHello(){
        return WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build()
                .get()
                .uri("/hello/success")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(HelloWorldModel.class)
                .map(helloWorldModel -> ResponseEntity.ok(helloWorldModel));
    }

    @GetMapping("clienterror")
    public Mono<ResponseEntity<HelloWorldModel>> sayHelloThrowClientError(){
        return WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build()
                .get()
                .uri("/hello/clienterror")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()

                .onStatus(HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(HelloWorldModel.class)
                        .map(CustomClientException::new))

                .bodyToMono(HelloWorldModel.class)
                .map(helloWorldModel -> ResponseEntity.ok(helloWorldModel));

    }

    @GetMapping("servererror")
    public Mono<ResponseEntity<HelloWorldModel>> sayHelloThrowServerError(){
        return WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build()
                .get()
                .uri("/hello/servererror")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(HelloWorldModel.class)
                .map(helloWorldModel -> ResponseEntity.ok(helloWorldModel));
    }

}
