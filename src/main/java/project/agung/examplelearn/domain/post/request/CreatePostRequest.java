package project.agung.examplelearn.domain.post.request;

import lombok.Data;

@Data
public class CreatePostRequest {

    private String title;
    private String description;
}
