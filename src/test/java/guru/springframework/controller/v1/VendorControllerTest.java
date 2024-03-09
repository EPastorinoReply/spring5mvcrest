package guru.springframework.controller.v1;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CategoryListDTO;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.api.v1.model.VendorListDTO;
import guru.springframework.controllers.v1.CategoryController;
import guru.springframework.controllers.v1.VendorController;
import guru.springframework.domain.Vendor;
import guru.springframework.services.CategoryService;
import guru.springframework.services.VendorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class VendorControllerTest {
    private final static String NAME = "Unipol";
    private final static Long ID = 2L;
    private final static String CATEGORY = "Insurance";
     VendorDTO vendorDTO = new VendorDTO(ID, NAME, CATEGORY);
//    VendorService vendorService  = Mockito.mock(VendorService.class);
//    VendorController vendorController = new VendorController(vendorService);
    @Mock
    VendorService vendorService;
    @InjectMocks
    VendorController vendorController;
    List<VendorDTO> vendors;
    @BeforeEach
    public void setUp(){
//        MockitoAnnotations.initMocks(this);
        vendors = Arrays.asList(new VendorDTO(), new VendorDTO(), new VendorDTO());
    }
    @Test
    void getAllVendors() {

        when(vendorService.getAllVendors()).thenReturn(vendors);
        //when
        VendorListDTO vendorListDTO= vendorController.getAllVendors();
        //then
        assertEquals(3, vendorListDTO.getVendors().size());

        verify(vendorService).getAllVendors();
    }

    @Test
    void getVendorByName() {
        when(vendorService.getVendorByName(NAME)).thenReturn(vendorDTO);
        VendorDTO vendorDTO1 = vendorController.getVendorByName(NAME);
        assertEquals(vendorDTO1.getName(), vendorDTO.getName());
        verify(vendorService).getVendorByName(NAME);
    }

    @Test
    void getVendorByCategory() {
    }

    @Test
    void getVendorById() {
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