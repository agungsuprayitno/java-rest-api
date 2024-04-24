package project.agung.examplelearn.global.request;

import lombok.Data;

@Data
public class GetPerPageRequest {

    private int page = 1;
    private int perPage = 20;

    public int getSizeOfPage() {
        return this.page - 1;
    }

}
