package project.agung.examplelearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import project.agung.examplelearn.global.security.AppJwtProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppJwtProperties.class)
public class ExampleLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleLearnApplication.class, args);
	}

}
