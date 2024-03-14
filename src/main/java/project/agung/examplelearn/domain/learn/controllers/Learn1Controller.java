package project.agung.examplelearn.domain.learn.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.agung.examplelearn.domain.learn.services.SayHelloService;

@RestController
@RequestMapping("/learn1")
public class Learn1Controller {

    private SayHelloService sayHelloService;

    Learn1Controller(SayHelloService sayHelloService) {
        this.sayHelloService = sayHelloService;
    }

    @GetMapping
    public void sayHello(){
        sayHelloService.sayHello();
    }
}
