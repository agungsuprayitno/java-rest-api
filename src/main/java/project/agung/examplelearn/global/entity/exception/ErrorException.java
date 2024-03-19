package project.agung.examplelearn.global.entity.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorException {

    @JsonProperty("error")
    private BodyException bodyException;
}
