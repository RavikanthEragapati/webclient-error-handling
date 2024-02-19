package com.eragapati.webclienterrorhandling.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorRespModel implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = 5665252607513860352L;
    private String errorCode;
    private String errorMsg;
}
