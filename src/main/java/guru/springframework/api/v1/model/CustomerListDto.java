package guru.springframework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
public class CustomerListDto {
    List<CustomerDto> customers;
}
