package project.agung.examplelearn.domain.post.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import project.agung.examplelearn.domain.post.entities.Post;
import project.agung.examplelearn.domain.post.repositories.PostRepository;
import project.agung.examplelearn.domain.post.request.GetPerPagePostRequest;

import java.util.List;

public class GetPerPagePostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPerPage(GetPerPagePostRequest request) {
        Pageable pagination = PageRequest.of(0, 2);
        Page<Post> listPostPage = this.postRepository.findAll(pagination);
        System.out.println(listPostPage.getContent());
        List<Post> listPost = this.postRepository.findAll();
        return listPost;
    }
}
