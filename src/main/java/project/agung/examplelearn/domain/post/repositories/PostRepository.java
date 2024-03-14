package project.agung.examplelearn.domain.post.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import project.agung.examplelearn.domain.post.entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, String> {

    List<Post> findByOrderByTitleAsc(int page, Pageable pageable);
}
