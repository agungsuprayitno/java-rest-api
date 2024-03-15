package project.agung.examplelearn.domain.post.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import project.agung.examplelearn.domain.post.dao.PostDao;
import project.agung.examplelearn.domain.post.entities.Post;
import project.agung.examplelearn.domain.post.exception.PostNotFoundException;
import project.agung.examplelearn.domain.post.repositories.PostRepository;
import project.agung.examplelearn.domain.post.request.UpdatePostRequest;

public class UpdatePostService {

    @Autowired
    private PostRepository postRepository;

    private PostDao postDao;

    public UpdatePostService() {
        if(this.postDao == null) {
            this.postDao = new PostDao();
        }
    }

    public Post updatePost(UpdatePostRequest request) {
        Post postToUpdate = postRepository.findById(request.getId()).orElseThrow(() -> new EntityNotFoundException("Post Not Found.", new PostNotFoundException()));

        Post post = postDao.setPostDAOUpdateAction(postToUpdate, request);
        postRepository.save(post);

        return postToUpdate;

    }
}
