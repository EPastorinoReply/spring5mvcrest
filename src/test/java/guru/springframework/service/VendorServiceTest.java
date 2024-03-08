package guru.springframework.service;

import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.api.v1.mapper.VendorMapper;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.repositories.VendorRepository;
import guru.springframework.services.CustomerService;
import guru.springframework.services.CustomerServiceImpl;
import guru.springframework.services.VendorService;
import guru.springframework.services.VendorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VendorServiceTest {
    Long ID = 2L;
    VendorRepository vendorRepository = Mockito.mock(VendorRepository.class);
    VendorService vendorService = new VendorServiceImpl(vendorRepository, VendorMapper.INSTANCE);

    @Test
    void getVendorById() {
        vendorRepository.findById(ID);
    }

    @Test
    void getVendorByName() {
    }

    @Test
    void getVendorByCategory() {
    }

    @Test
    void getAllVendors() {
    }

    @Test
    void createVendor() {
    }

    @Test
    void updateVendor() {
    }

    @Test
    void deleteVendor() {
    }
}
