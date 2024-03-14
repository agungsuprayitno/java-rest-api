package project.agung.examplelearn.domain.post.dto;

import lombok.Data;

@Data
public class PostDto {

    private String ID;
    private String title;
    private String description;

    public PostDto getPostDTO() {
        PostDto postDto = new PostDto();
        postDto.ID = this.ID;
        postDto.title = this.title;
        postDto.description = this.description;
        return postDto;
    }
}
