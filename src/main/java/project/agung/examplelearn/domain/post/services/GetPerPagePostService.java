package project.agung.examplelearn.domain.post.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import project.agung.examplelearn.domain.post.entities.Post;
import project.agung.examplelearn.domain.post.repositories.PostRepository;
import project.agung.examplelearn.global.request.GetPerPageRequest;

public class GetPerPagePostService {

    @Autowired
    private PostRepository postRepository;

    public Page<Post> getPerPage(GetPerPageRequest request) {
        Pageable pagination = PageRequest.of(request.getSizeOfPage(), request.getPerPage());
        Page<Post> listPostPage = this.postRepository.findAll(pagination);
        return listPostPage;
    }
}
