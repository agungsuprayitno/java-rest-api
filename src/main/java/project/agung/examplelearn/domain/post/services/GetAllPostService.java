package project.agung.examplelearn.domain.post.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import project.agung.examplelearn.domain.post.dao.PostDao;
import project.agung.examplelearn.domain.post.entities.Post;
import project.agung.examplelearn.domain.post.repositories.PostRepository;
import project.agung.examplelearn.domain.post.request.CreatePostRequest;

import java.util.List;

public class GetAllPostService {

    @Autowired
    private PostRepository postRepository;

    public void getAllPost() {
//       List<Post> allPost = postRepository.findByOrderByTitleAsc();
//       System.out.println(allPost);
    }
}
