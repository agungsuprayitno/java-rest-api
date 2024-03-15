package project.agung.examplelearn.domain.post.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.agung.examplelearn.domain.post.entities.Post;
import project.agung.examplelearn.domain.post.request.CreatePostRequest;
import project.agung.examplelearn.domain.post.request.GetPerPageRequest;
import project.agung.examplelearn.domain.post.request.UpdatePostRequest;
import project.agung.examplelearn.domain.post.services.CreatePostService;
import project.agung.examplelearn.domain.post.services.GetAllPostService;
import project.agung.examplelearn.domain.post.services.GetPerPagePostService;
import project.agung.examplelearn.domain.post.services.UpdatePostService;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private final GetPerPagePostService getPerPagePostService;
    private final GetAllPostService getAllPostService;
    private final CreatePostService createPostService;
    private final UpdatePostService updatePostService;

    @Autowired
    private GetPerPageRequest getPerPageRequest;
    PostController(CreatePostService createPostService,
                   GetPerPagePostService getPerPagePostService,
                   GetAllPostService getAllPostService,
                   UpdatePostService updatePostService){
        this.getPerPagePostService = getPerPagePostService;
        this.getAllPostService = getAllPostService;
        this.createPostService = createPostService;
        this.updatePostService = updatePostService;
    }

    @GetMapping
    public ResponseEntity<Page<Post>> getPerPage(GetPerPageRequest request){
        Page<Post> listPostPage = getPerPagePostService.getPerPage(request);
        return new ResponseEntity<>(listPostPage, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAll(){
        List<Post> listPost = getAllPostService.getAllPost();
        return new ResponseEntity<>(listPost, HttpStatus.OK);
    }

    @PostMapping
    public void createPost(@RequestBody CreatePostRequest request) {
        createPostService.createPost(request);
    }

    @PatchMapping
    public ResponseEntity<Post> updateProduct(@RequestBody UpdatePostRequest request) {
        Post post = updatePostService.updatePost(request);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
