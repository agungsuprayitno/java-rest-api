package project.agung.examplelearn.domain.post.request;

import lombok.Data;

@Data
public class GetPerPageRequest {

    private int page = 0;
    private int perPage = 20;
    private String sortBy;
    private String sortType = "Asc";

}
