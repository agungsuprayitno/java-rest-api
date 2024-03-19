package project.agung.examplelearn.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import project.agung.examplelearn.global.response.ApiResponse;
import project.agung.examplelearn.global.response.PaginationResponse;

@Component
public class ResponseConfig {

    @Bean
    public ApiResponse bodyResponse() {
        return new ApiResponse();
    }

    @Bean
    public PaginationResponse paginationResponse() {
        return new PaginationResponse();
    }
}
