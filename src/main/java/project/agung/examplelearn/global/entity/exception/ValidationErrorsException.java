package project.agung.examplelearn.global.entity.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationErrorsException extends BodyException {
    @JsonProperty("validations")
    private List<ValidationException> validationExceptions = new ArrayList<>();
}
