package com.eragapati.webclienterrorhandling.controller;

import com.eragapati.webclienterrorhandling.model.ErrorRespModel;
import com.eragapati.webclienterrorhandling.model.HelloWorldModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    @GetMapping("success")
    public ResponseEntity<HelloWorldModel> sayHello(){
        return ResponseEntity
                .ok(HelloWorldModel
                        .builder()
                        .actualRespText("success")
                        .build());
    }

    @GetMapping("clienterror")
    public ResponseEntity<HelloWorldModel> sayHelloThrowClientError(){
        return ResponseEntity
                .badRequest()
                .body(HelloWorldModel
                        .builder()
                        .error(ErrorRespModel
                                .builder()
                                .errorCode("409")
                                .errorMsg("client error message")
                                .build())
                        .build());
    }

    @GetMapping("servererror")
    public ResponseEntity<HelloWorldModel> sayHelloThrowServerError(){
        return ResponseEntity
                .internalServerError()
                .body(HelloWorldModel
                        .builder()
                        .error(ErrorRespModel
                                .builder()
                                .errorCode("500")
                                .errorMsg("server error message")
                                .build())
                        .build());
    }
}
