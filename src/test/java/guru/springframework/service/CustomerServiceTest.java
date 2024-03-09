package guru.springframework.service;

import guru.springframework.api.v1.mapper.CategoryMapper;
import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CustomerDto;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.services.CategoryService;
import guru.springframework.services.CategoryServiceImpl;
import guru.springframework.services.CustomerService;
import guru.springframework.services.CustomerServiceImpl;
import jakarta.persistence.Id;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {
    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";

    CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
    CustomerService customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);

    //    @Rule //initMocks
//    public MockitoRule rule = MockitoJUnit.rule();
//    @Before("")
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//
//        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
//    }
//    @BeforeEach
//    public void setUp() throws Exception{
//        Customer customer = new Customer();
//        customer.setId(ID);
//        customer.setFirstname(NAME);
//    }

    @Test
    public void getAllCustomer() throws Exception {

        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDto> customerDtos = customerService.getAllCustomer();

        //then
        assertEquals(3, customerDtos.size());

    }

    @Test
    public void getCustomerByName() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(NAME);

        when(customerRepository.findByFirstname(anyString())).thenReturn(customer);

        //when
        CustomerDto customerDto = customerService.getCustomerByName(NAME);

        //then
        assertEquals(ID, customerDto.getId());
        assertEquals(NAME, customerDto.getFirstname());

    }
    @Test
    public void getCustomerById() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(NAME);

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        //when
        CustomerDto customerDto = customerService.getCustomerById(ID);

        //then
        assertEquals(ID, customerDto.getId());
        assertEquals(NAME, customerDto.getFirstname());
        verify(customerRepository, times(1)).findById(ID);

    }
}
