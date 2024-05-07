package guru.springframework.api.v1.model;

import lombok.*;

@Data
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String customer_url;
}
