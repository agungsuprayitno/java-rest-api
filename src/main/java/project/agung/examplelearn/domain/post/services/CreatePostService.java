package project.agung.examplelearn.domain.post.services;

import org.springframework.beans.factory.annotation.Autowired;
import project.agung.examplelearn.domain.post.dao.PostDao;
import project.agung.examplelearn.domain.post.entities.Post;
import project.agung.examplelearn.domain.post.repositories.PostRepository;
import project.agung.examplelearn.domain.post.request.CreatePostRequest;

public class CreatePostService {

    @Autowired
    private PostRepository postRepository;

    private PostDao postDao;

    public CreatePostService() {
        if(this.postDao == null) {
            this.postDao = new PostDao();
        }
    }

    public void createPost(CreatePostRequest request) {
        Post post = postDao.setPostDAOCreateAction(request);
        postRepository.save(post);
    }
}
