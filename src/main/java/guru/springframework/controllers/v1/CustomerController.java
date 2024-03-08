package guru.springframework.controllers.v1;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CategoryListDTO;
import guru.springframework.api.v1.model.CustomerDto;
import guru.springframework.api.v1.model.CustomerListDto;
import guru.springframework.domain.Customer;
import guru.springframework.services.CategoryService;
import guru.springframework.services.CustomerService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    //
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDto getAllCustomer(){

        return new CustomerListDto(customerService.getAllCustomer());
    }

    @GetMapping("/name/{firstname}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerByName(@PathVariable String firstname){
        return customerService.getCustomerByName(firstname);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto){

        return customerService.createCustomer(customerDto);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto UpdateCustomer(@RequestBody CustomerDto customerDto, @PathVariable Long id){

        return customerService.updateCustomer(customerDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
