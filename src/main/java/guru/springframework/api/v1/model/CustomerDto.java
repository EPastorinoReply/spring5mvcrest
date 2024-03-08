package guru.springframework.api.v1.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter@Setter
public class CustomerDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String customer_url;
}
