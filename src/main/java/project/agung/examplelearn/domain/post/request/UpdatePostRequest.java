package project.agung.examplelearn.domain.post.request;

import lombok.Data;

@Data
public class UpdatePostRequest {

    private String id;
    private String title;
    private String description;
}
