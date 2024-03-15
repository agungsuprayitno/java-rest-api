package project.agung.examplelearn.global.exceptionhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import project.agung.examplelearn.global.entity.BodyException;
import project.agung.examplelearn.global.entity.ErrorException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalClientExceptionHandler {
    private BodyException bodyException;
    private ErrorException errorException;

    public GlobalClientExceptionHandler(){
        if(this.bodyException == null) { this.bodyException = new BodyException(); }
        if(this.errorException == null) { this.errorException = new ErrorException(); }
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) throws JsonProcessingException {
        this.bodyException.setStatus(HttpStatus.NOT_FOUND.value());
        this.bodyException.setCode(ex.getCause().getMessage());
        this.bodyException.setMessage(ex.getMessage());

        this.errorException.setBodyException(this.bodyException);

        ObjectMapper mapper = new ObjectMapper();
        String errorExceptionJson = mapper.writeValueAsString(this.errorException);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorExceptionJson);
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

    // Add more exception handlers as needed
}
