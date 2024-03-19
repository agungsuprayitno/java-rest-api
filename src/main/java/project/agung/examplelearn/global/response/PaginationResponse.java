package project.agung.examplelearn.global.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PaginationResponse {

    @JsonProperty("current_page")
    private int currentPage = 1;

    @JsonProperty("per_page")
    private int perPage = 20;

    @JsonProperty("total_page")
    private int totalPages = 0;

    @JsonProperty("total_record")
    private long totalRecord = 0;

    @JsonProperty("prev_page")
    private boolean prevPage = false;

    @JsonProperty("next_page")
    private boolean nextPage = false;

    public PaginationResponse setPagination(Page page){
        this.currentPage = page.getNumber() + 1;
        this.perPage = page.getSize();
        this.totalPages = page.getTotalPages();
        this.totalRecord = page.getTotalElements();
        this.prevPage = !page.isFirst();
        this.nextPage = !page.isLast();

        this.currentPage = page.getNumber() + 1;
        this.perPage = page.getSize();
        this.totalPages = page.getTotalPages();
        this.totalRecord = page.getTotalElements();
        this.prevPage = !page.isFirst();
        this.nextPage = !page.isLast();
        return this;
    }

}
