package project.agung.examplelearn.domain.post.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.agung.examplelearn.domain.post.entities.Post;
import project.agung.examplelearn.domain.post.request.CreatePostRequest;
import project.agung.examplelearn.domain.post.request.GetPerPagePostRequest;
import project.agung.examplelearn.domain.post.services.CreatePostService;
import project.agung.examplelearn.domain.post.services.GetPerPagePostService;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private final CreatePostService createPostService;
    private final GetPerPagePostService getPerPagePostService;

    @Autowired
    private GetPerPagePostRequest getPerPagePostRequest;
    PostController(CreatePostService createPostService, GetPerPagePostService getPerPagePostService){
        this.createPostService = createPostService;
        this.getPerPagePostService = getPerPagePostService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPerPage(GetPerPagePostRequest request){
        List<Post> listPost = getPerPagePostService.getPerPage(request);
        return new ResponseEntity<>(listPost, HttpStatus.OK);
    }

    @PostMapping
    public void createPost(@RequestBody CreatePostRequest request) {
        createPostService.createPost(request);
    }
}
