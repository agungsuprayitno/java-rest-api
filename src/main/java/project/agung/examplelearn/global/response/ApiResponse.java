package project.agung.examplelearn.global.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse <T> {
    private T data;
    private Optional<T> meta;

}
