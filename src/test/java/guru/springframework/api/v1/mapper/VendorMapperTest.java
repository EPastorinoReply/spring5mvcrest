package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CustomerDto;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Vendor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static guru.springframework.api.v1.mapper.CustomerMapperTest.SURNAME;

public class VendorMapperTest {
    public static final String NAME = "Unipol";
    public static final String CATEGORY = "finance";
    public static final long ID = 1L;
    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @Test
    public void vendorToVendorDTO() throws Exception {
    Vendor vendor = new Vendor();
        vendor.setName(NAME);
        vendor.setId(ID);

    //when
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);

    //then

        Assertions.assertEquals(Long.valueOf(ID), vendorDTO.getId());
        Assertions.assertEquals(NAME, vendorDTO.getName());
}
@Test
public void vendorDTOToVendor() throws Exception {

    //given
    VendorDTO vendorDTO = new VendorDTO();
    vendorDTO.setName(NAME);
    vendorDTO.setCategory(CATEGORY);
    vendorDTO.setId(ID);

    //when
    Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);

    //then

    Assertions.assertEquals(Long.valueOf(ID), vendor.getId());
    Assertions.assertEquals(NAME, vendor.getName());
    Assertions.assertEquals(CATEGORY, vendor.getCategory());
}

}
