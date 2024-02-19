package com.eragapati.webclienterrorhandling.controller;

import com.eragapati.webclienterrorhandling.model.HelloWorldModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "clientUsingExchange")
public class ClientUsingExchangeController {

    @GetMapping("success")
    public Mono<ResponseEntity<HelloWorldModel>> sayHello(){
        return WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build()
                .get()
                .uri("/hello/success")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(resp -> {
                    if (HttpStatus.OK.equals(resp.statusCode())) {
                        return resp.bodyToMono(HelloWorldModel.class);
                    } else if (HttpStatus.BAD_REQUEST.equals(resp.statusCode())) {
                        return resp.bodyToMono(HelloWorldModel.class);
                    } else if (HttpStatus.INTERNAL_SERVER_ERROR.equals(resp.statusCode())) {
                        return resp.bodyToMono(HelloWorldModel.class);
                    }
                    else return resp.createError();
                })
                .map(helloWorld -> ResponseEntity.ok(helloWorld));
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
                .exchange()
                .flatMap(resp -> {
                    if (HttpStatus.OK.equals(resp.statusCode())) {
                        return resp.bodyToMono(HelloWorldModel.class);
                    } else if (HttpStatus.BAD_REQUEST.equals(resp.statusCode())) {
                        return resp.bodyToMono(HelloWorldModel.class);
                    } else if (HttpStatus.INTERNAL_SERVER_ERROR.equals(resp.statusCode())) {
                        return resp.bodyToMono(HelloWorldModel.class);
                    }
                    else return resp.createError();
                })
                .map( helloWorld -> ResponseEntity.ok(helloWorld));

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
                .exchangeToMono(resp -> {
                    if (HttpStatus.OK.equals(resp.statusCode())) {
                        return resp.bodyToMono(HelloWorldModel.class);
                    } else if (HttpStatus.BAD_REQUEST.equals(resp.statusCode())) {
                        return resp.bodyToMono(HelloWorldModel.class);
                    } else if (HttpStatus.INTERNAL_SERVER_ERROR.equals(resp.statusCode())) {
                        return resp.bodyToMono(HelloWorldModel.class);
                    }
                    else return resp.createError();
                })
                .map(helloWorld -> ResponseEntity.ok(helloWorld));
    }

}
