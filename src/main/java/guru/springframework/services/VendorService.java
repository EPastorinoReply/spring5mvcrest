package guru.springframework.services;

import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.api.v1.model.VendorListDTO;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.VendorRepository;

import java.util.List;

public interface VendorService {
    VendorDTO getVendorById(Long id);
    VendorDTO getVendorByName(String name);
    VendorDTO getVendorByCategory(String Category);
    List<VendorDTO> getAllVendors();
    VendorDTO createVendor(VendorDTO vendorDTO);
    VendorDTO updateVendor(Long id, VendorDTO vendorDTO);
    Long deleteVendor(Long id);

}
