package project.agung.examplelearn.domain.learn.services;

import project.agung.examplelearn.domain.learn.repositories.SayHelloRepository;

public class SayHelloService {

    private final SayHelloRepository sayHelloRepository;

    public SayHelloService(SayHelloRepository sayHelloRepository) {
        this.sayHelloRepository = sayHelloRepository;
    }

    public void sayHello() {
        this.sayHelloRepository.sayHello();
    }
}
