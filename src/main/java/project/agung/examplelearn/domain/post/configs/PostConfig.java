package project.agung.examplelearn.domain.post.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.agung.examplelearn.domain.post.dao.PostDao;
import project.agung.examplelearn.domain.post.dto.PostDto;
import project.agung.examplelearn.domain.post.services.CreatePostService;
import project.agung.examplelearn.domain.post.services.GetAllPostService;
import project.agung.examplelearn.domain.post.services.GetPerPagePostService;
import project.agung.examplelearn.domain.post.services.UpdatePostService;

@Configuration
public class PostConfig {

    @Bean
    public PostDto postDto() {
        return new PostDto();
    }

    @Bean
    public PostDao postDao() {
        return new PostDao();
    }

    @Bean
    public CreatePostService createPostService() {
        return new CreatePostService();
    }

    @Bean
    public GetPerPagePostService getPerPagePostService() {
        return new GetPerPagePostService();
    }

    @Bean
    public GetAllPostService getAllPostService() {
        return new GetAllPostService();
    }

    @Bean
    public UpdatePostService UpdatePostService() {
        return new UpdatePostService();
    }

}
