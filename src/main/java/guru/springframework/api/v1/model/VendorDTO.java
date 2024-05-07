package guru.springframework.api.v1.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendorDTO {
    private Long Id;
    private String name;
    private String category;

}
