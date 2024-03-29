package project.agung.examplelearn.domain.post.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdatePostRequest {

    @NotBlank(message = "Id is required.")
    private String id;

    @NotNull(message = "Title cannot be null.")
    @NotBlank(message = "Title is required.")
    private String title;

    @NotNull(message = "Description cannot be null.")
    @NotBlank(message = "Description is required.")
    private String description;
}
