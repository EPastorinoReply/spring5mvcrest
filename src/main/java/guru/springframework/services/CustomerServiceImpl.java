package guru.springframework.services;

import guru.springframework.api.v1.mapper.CategoryMapper;
import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.api.v1.model.CustomerDto;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerByName(String firstname) {
        Customer customer = customerRepository.findByFirstname(firstname);
        if(customer == null){
            throw new NoSuchElementException();
        }
        return customerMapper.customerToCustomerDTO(customer);

    }
    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerDTO(customer);

    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
//        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
//        try{
//            customerRepository.save(customer);
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
        return customerMapper.customerToCustomerDTO(customerRepository.save(customerMapper.customerDtoToCustomer(customerDto)));
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Long id) {
        CustomerDto findCust = getCustomerById(id);
        findCust.setFirstname(customerDto.getFirstname());
        findCust.setLastname(customerDto.getLastname());
        findCust.setCustomer_url(customerDto.getCustomer_url());
        try{
            customerRepository.save(customerMapper.customerDtoToCustomer(findCust));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return findCust;
    }
    @Override
    public Long deleteCustomer(Long id){

        getCustomerById(id);
        customerRepository.deleteById(id);
        return id;
    }
}
