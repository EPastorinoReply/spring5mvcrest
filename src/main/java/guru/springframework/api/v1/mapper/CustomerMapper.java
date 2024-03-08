package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CustomerDto;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "url", target = "customer_url" )
    CustomerDto customerToCustomerDTO(Customer customer);

    @Mapping(source = "customer_url", target = "url" )
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
