package project.agung.examplelearn.domain.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.agung.examplelearn.domain.learn.repositories.SayHelloRepository;
import project.agung.examplelearn.domain.learn.services.SayHelloService;

@Configuration
public class Learn1Config {

    @Bean
    public SayHelloRepository sayHelloRepository(){
        return new SayHelloRepository();
    }

    @Bean
    public SayHelloService sayHelloService(){
        return new SayHelloService(this.sayHelloRepository());
    }

}
