package project.agung.examplelearn.global.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValidationException {

    @JsonProperty("field_name")
    private final String fieldName;

    @JsonProperty("message")
    private final String message;
}
