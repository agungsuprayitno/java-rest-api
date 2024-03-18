package project.agung.examplelearn.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import project.agung.examplelearn.global.response.ApiResponse;

@Component
public class ResponseConfig {

    @SuppressWarnings("rawtypes")
    @Bean
    public ApiResponse bodyResponse() {
        return new ApiResponse();
    }
}
