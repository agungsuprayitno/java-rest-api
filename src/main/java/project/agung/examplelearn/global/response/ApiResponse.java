package project.agung.examplelearn.global.response;


import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ApiResponse <T> {
    private T data;
    private Object meta;

    public ApiResponse() {

    }
}
