package guru.springframework.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    private String category;
}
