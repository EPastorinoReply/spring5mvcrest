package guru.springframework.services;

import guru.springframework.api.v1.mapper.VendorMapper;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {
    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorMapper.vendorToVendorDTO(
                vendorRepository.findById(id).get()
        );

    }

    @Override
    public VendorDTO getVendorByName(String name) {
        return vendorMapper.vendorToVendorDTO(
                vendorRepository.findByName(name)
        );
    }

    @Override
    public VendorDTO getVendorByCategory(String category) {
        return vendorMapper.vendorToVendorDTO(
                vendorRepository.findByCategory(category)
        );
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(vendorMapper::vendorToVendorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO createVendor(VendorDTO vendorDTO) {

        return vendorMapper.vendorToVendorDTO(
                vendorRepository.save(
                        vendorMapper.vendorDTOToVendor(vendorDTO)
                )
        );
    }

    @Override
    public VendorDTO updateVendor(Long id, VendorDTO vendorDTO) {
       VendorDTO foundVendor =  getVendorById(id);
       foundVendor.setCategory(vendorDTO.getCategory());
       foundVendor.setName(vendorDTO.getName());
       return foundVendor;
    }

    @Override
    public Long deleteVendor(Long id) {
        getVendorById(id);
        vendorRepository.deleteById(id);
        return id;
    }
}
