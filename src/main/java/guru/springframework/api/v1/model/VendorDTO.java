package guru.springframework.api.v1.model;

import lombok.Data;

@Data
public class VendorDTO {
    private Long Id;
    private String name;
    private String category;

}
