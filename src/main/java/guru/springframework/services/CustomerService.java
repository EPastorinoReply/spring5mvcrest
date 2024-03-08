package guru.springframework.services;

import guru.springframework.api.v1.model.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomer();
    CustomerDto getCustomerByName(String firstname);

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(Long id);

    CustomerDto updateCustomer(CustomerDto customerDto, Long id);

    Long deleteCustomer(Long id);
}
