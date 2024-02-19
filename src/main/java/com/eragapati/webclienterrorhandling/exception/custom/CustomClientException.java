package com.eragapati.webclienterrorhandling.exception.custom;

import com.eragapati.webclienterrorhandling.model.HelloWorldModel;
import lombok.*;

import java.io.Serial;

@Getter
public class CustomClientException extends Exception{
    @Serial
    private static final long serialVersionUID = -3804344572933284192L;
    private HelloWorldModel helloWorldModel;

    public CustomClientException(HelloWorldModel helloWorldModel){
        this.helloWorldModel= helloWorldModel;
    }

}
