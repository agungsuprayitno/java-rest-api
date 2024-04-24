package project.agung.examplelearn.global.exceptionhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import project.agung.examplelearn.global.entity.exception.BodyException;
import project.agung.examplelearn.global.entity.exception.ErrorException;
import project.agung.examplelearn.global.entity.exception.ValidationException;
import project.agung.examplelearn.global.entity.exception.ValidationErrorsException;

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
    @ResponseBody
    ErrorException handleEntityNotFoundException(EntityNotFoundException ex) throws JsonProcessingException {
        this.bodyException.setStatus(HttpStatus.NOT_FOUND.value());
        this.bodyException.setCode(ex.getCause().getMessage());
        this.bodyException.setMessage(ex.getMessage());

        this.errorException.setBodyException(this.bodyException);
        return this.errorException;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorException onConstraintValidationException(
            ConstraintViolationException e) {
        ValidationErrorsException error = new ValidationErrorsException();
        error.setStatus(400);
        error.setMessage("Bad Error Request.");
        error.setCode("bad-error-request");
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            error.getValidationExceptions().add(
                    new ValidationException(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        this.errorException.setBodyException(error);
        return this.errorException;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorException onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        ValidationErrorsException error = new ValidationErrorsException();
        error.setStatus(400);
        error.setMessage("Validation Error Requests.");
        error.setCode("validation-error");
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.getValidationExceptions().add(
                    new ValidationException(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        this.errorException.setBodyException(error);
        return this.errorException;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorException illegalArgumentException(IllegalArgumentException ex) {
        this.bodyException.setStatus(HttpStatus.BAD_REQUEST.value());
        this.bodyException.setCode(ex.getCause().getMessage());
        this.bodyException.setMessage(ex.getMessage());

        this.errorException.setBodyException(this.bodyException);
        return this.errorException;
    }

    // Add more exception handlers as needed
}
