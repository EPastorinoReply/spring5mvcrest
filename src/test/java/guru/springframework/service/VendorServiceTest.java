package guru.springframework.service;

import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.api.v1.mapper.VendorMapper;
import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CustomerDto;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.repositories.VendorRepository;
import guru.springframework.services.CustomerService;
import guru.springframework.services.CustomerServiceImpl;
import guru.springframework.services.VendorService;
import guru.springframework.services.VendorServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VendorServiceTest {
    public static final Long ID = 2L;
    public static final String NAME = "Unipol";
    public static final String CATEGORY = "Insurance";
    VendorRepository vendorRepository = Mockito.mock(VendorRepository.class);
    VendorService vendorService = new VendorServiceImpl(vendorRepository, VendorMapper.INSTANCE);
    VendorMapper vendorMapper = Mockito.mock(VendorMapper.class);
    public static Vendor vendor = new Vendor();

    @BeforeAll
    public static void setUp(){
        vendor.setId(ID);
        vendor.setName(NAME);
        vendor.setCategory(CATEGORY);
    }
    @Test
    void getVendorById() {

        when(vendorRepository.findById(anyLong())).thenReturn(Optional.of(vendor));
        VendorDTO vendorDTO = vendorService.getVendorById(ID);
        assertEquals(ID, vendorDTO.getId());
        verify(vendorRepository).findById(any());
    }

    @Test
    void getVendorByName() {

        when(vendorRepository.findByName(anyString())).thenReturn(vendor);

        //when
        VendorDTO vendorDTO = vendorService.getVendorByName(NAME);

        //then
        assertEquals(NAME, vendorDTO.getName());
        verify(vendorRepository).findByName(any());
    }

    @Test
    void getVendorByCategory() {

        when(vendorRepository.findByCategory(anyString())).thenReturn(vendor);

        //when
        VendorDTO vendorDTO = vendorService.getVendorByCategory(CATEGORY);

        //then
        assertEquals(CATEGORY, vendorDTO.getCategory());
        verify(vendorRepository).findByCategory(any());
    }

    @Test
    void getAllVendors() {

        List<Vendor> vendors = Arrays.asList(new Vendor(), new Vendor(), new Vendor());

        when(vendorRepository.findAll()).thenReturn(vendors);

        //when
        List<VendorDTO> vendorDTOS = vendorService.getAllVendors();

        //then
        assertEquals(3, vendorDTOS.size());
        verify(vendorRepository).findAll();
    }

    @Test
    void createVendor() {
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setId(ID);
        vendorDTO.setCategory(CATEGORY);
        vendorDTO.setName(NAME);

        when(vendorRepository.save(vendor)).thenReturn(vendor);

        VendorDTO vendorDTORes = vendorService.createVendor(vendorDTO);
        assertEquals(vendorDTORes.getName(), vendor.getName());
        assertEquals(vendorDTORes.getCategory(), vendor.getCategory());
        verify(vendorRepository).save(any());

    }

    @Test
    void updateVendor() {
        when(vendorRepository.findById(anyLong())).thenReturn(Optional.of(vendor));
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setId(ID);
        vendorDTO.setCategory(CATEGORY);
        vendorDTO.setName("Unipol SAI");

        VendorDTO vendorDTORes = vendorService.updateVendor(vendorDTO.getId(), vendorDTO);
        assertEquals(vendorDTORes.getName(), vendorDTO.getName());
        verify(vendorRepository).findById(any());
    }

    @Test
    void deleteVendor() {
        when(vendorRepository.findById(anyLong())).thenReturn(Optional.of(vendor));
        Long delId = vendorService.deleteVendor(ID);
        assertEquals(delId, ID);
        verify(vendorRepository).findById(any());
        verify(vendorRepository).deleteById(any());
    }
}
