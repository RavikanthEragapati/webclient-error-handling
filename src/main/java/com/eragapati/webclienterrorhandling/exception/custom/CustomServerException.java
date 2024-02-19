package com.eragapati.webclienterrorhandling.exception.custom;

import lombok.Getter;

import java.io.Serial;

@Getter
public class CustomServerException extends Exception{
    @Serial
    private static final long serialVersionUID = -2748033914921738417L;

}
