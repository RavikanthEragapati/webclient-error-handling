package com.eragapati.webclienterrorhandling.model;

import lombok.*;

import java.io.Serial;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorldModel implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = -8830792383720182430L;
    private String actualRespText;
    private ErrorRespModel error;
}
