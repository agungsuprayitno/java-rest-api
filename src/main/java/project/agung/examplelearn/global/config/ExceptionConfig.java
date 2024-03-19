package project.agung.examplelearn.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.agung.examplelearn.global.entity.exception.BodyException;
import project.agung.examplelearn.global.entity.exception.ErrorException;

@Configuration
public class ExceptionConfig {

    @Bean
    public BodyException bodyException() {
        return new BodyException();
    }

    @Bean
    public ErrorException errorException() {
        return new ErrorException();
    }
}
