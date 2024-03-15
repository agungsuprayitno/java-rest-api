package project.agung.examplelearn.domain.post.services;

import org.springframework.beans.factory.annotation.Autowired;
import project.agung.examplelearn.domain.post.entities.Post;
import project.agung.examplelearn.domain.post.repositories.PostRepository;

import java.util.List;

public class GetAllPostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPost() {
        List<Post> listPost = this.postRepository.findAll();
        return listPost;
    }
}
