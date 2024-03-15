package project.agung.examplelearn.domain.post.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostNotFoundException extends Exception {
    public PostNotFoundException() { super("post-not-found"); }
}
