package project.agung.examplelearn.domain.post.controllers;

import jakarta.validation.Valid;
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
import project.agung.examplelearn.global.entity.pagination.Pagination;
import project.agung.examplelearn.global.response.ApiResponse;
import project.agung.examplelearn.global.response.PaginationResponse;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final GetPerPagePostService getPerPagePostService;
    private final GetAllPostService getAllPostService;
    private final CreatePostService createPostService;
    private final UpdatePostService updatePostService;

    private final PaginationResponse paginationResponse;

    @Autowired
    private GetPerPageRequest getPerPageRequest;
    PostController(CreatePostService createPostService,
                   GetPerPagePostService getPerPagePostService,
                   GetAllPostService getAllPostService,
                   UpdatePostService updatePostService,
                   PaginationResponse paginationResponse){
        this.getPerPagePostService = getPerPagePostService;
        this.getAllPostService = getAllPostService;
        this.createPostService = createPostService;
        this.updatePostService = updatePostService;
        this.paginationResponse = paginationResponse;
    }

    @GetMapping
    public ResponseEntity<Object> getPerPage(GetPerPageRequest request){
        Page<Post> listPostPage = getPerPagePostService.getPerPage(request);
        Object pagination = this.paginationResponse.setPagination(listPostPage);
        Pagination pagination1 = new Pagination<>(pagination);
        ApiResponse<List<Post>> response = new ApiResponse<>(listPostPage.toList(), pagination1);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAll(){
        List<Post> listPost = getAllPostService.getAllPost();
        ApiResponse<List<Post>> response = new ApiResponse<>(listPost,null);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public void createPost(@Valid @RequestBody CreatePostRequest request) {
        createPostService.createPost(request);
    }

    @PatchMapping
    public ResponseEntity<Post> updateProduct(@RequestBody UpdatePostRequest request) {
        Post post = updatePostService.updatePost(request);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
