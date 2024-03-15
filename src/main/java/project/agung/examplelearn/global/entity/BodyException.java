package project.agung.examplelearn.global.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BodyException {
    private int status;

    @JsonProperty("error_code")
    private String code;

    private String message;
}


