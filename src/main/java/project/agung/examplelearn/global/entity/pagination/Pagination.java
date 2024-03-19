package project.agung.examplelearn.global.entity.pagination;

import lombok.Data;

@Data
public class Pagination<T> {
    
    private T pagination;

    public Pagination(T pagination) {
        this.pagination = pagination;
    }
}
