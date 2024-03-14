package project.agung.examplelearn.domain.post.dao;

import lombok.Data;
import project.agung.examplelearn.domain.post.dto.PostDto;
import project.agung.examplelearn.domain.post.entities.Post;
import project.agung.examplelearn.domain.post.request.CreatePostRequest;
import project.agung.examplelearn.domain.post.request.UpdatePostRequest;

@Data
public class PostDao {
    public Post setPostDAOCreateAction(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setDescription(createPostRequest.getDescription());
        return post;
    }

    public Post setPostDAOUpdateAction(UpdatePostRequest updatePostRequest) {
        Post post = new Post();
        post.setTitle(updatePostRequest.getTitle());
        post.setDescription(updatePostRequest.getDescription());
        return post;
    }

}
