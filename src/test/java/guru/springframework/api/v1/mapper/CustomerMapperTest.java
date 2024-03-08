package guru.springframework.api.v1.mapper;


import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CustomerDto;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class CustomerMapperTest {

    public static final String NAME = "Ringo";
    public static final String SURNAME = "Starr";
    public static final long ID = 1L;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setFirstname(NAME);
        customer.setId(ID);

        //when
        CustomerDto customerDto = customerMapper.customerToCustomerDTO(customer);

        //then

        Assertions.assertEquals(Long.valueOf(ID), customerDto.getId());
        Assertions.assertEquals(NAME, customerDto.getFirstname());
    }
    @Test
    public void customerDtoToCustomer() throws Exception {

        //given
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstname(NAME);
        customerDto.setLastname(SURNAME);
        customerDto.setId(ID);

        //when
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);

        //then

        Assertions.assertEquals(Long.valueOf(ID), customer.getId());
        Assertions.assertEquals(NAME, customer.getFirstname());
        Assertions.assertEquals(SURNAME, customer.getLastname());
    }


}