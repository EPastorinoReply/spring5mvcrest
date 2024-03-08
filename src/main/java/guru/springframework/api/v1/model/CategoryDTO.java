package guru.springframework.api.v1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CategoryDTO {
    private Long id;
    private String name;
}

