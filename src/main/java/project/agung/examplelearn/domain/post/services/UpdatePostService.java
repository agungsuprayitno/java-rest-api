package project.agung.examplelearn.domain.post.services;

import org.springframework.beans.factory.annotation.Autowired;
import project.agung.examplelearn.domain.post.dao.PostDao;
import project.agung.examplelearn.domain.post.entities.Post;
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

    public void createPost(UpdatePostRequest request) {
        Post post = postDao.setPostDAOUpdateAction(request);
        postRepository.save(post);
    }
}
