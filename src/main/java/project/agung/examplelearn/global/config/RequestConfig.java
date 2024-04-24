package project.agung.examplelearn.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.agung.examplelearn.global.request.GetPerPageRequest;

@Configuration
public class RequestConfig {

    @Bean
    public GetPerPageRequest getPerPageRequest() {
        return new GetPerPageRequest();
    }
}
