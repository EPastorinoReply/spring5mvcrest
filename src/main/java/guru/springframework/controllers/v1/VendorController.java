package guru.springframework.controllers.v1;

import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.api.v1.model.VendorListDTO;
import guru.springframework.domain.Vendor;
import guru.springframework.services.VendorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vendors")
public class VendorController {

    private final VendorService vendorService;


    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all vendors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the vendor by name",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VendorDTO.class))}
            ),
    }
    )
    public VendorListDTO getAllVendors(){
       return new VendorListDTO(vendorService.getAllVendors());
    }
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Vendor by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the vendor by name",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VendorDTO.class))}
            ),
            @ApiResponse(responseCode = "400", description = "Invalid Name supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Vendor not found",
                    content = @Content)
    }
    )
    public VendorDTO getVendorByName(@PathVariable String name){
        return vendorService.getVendorByName(name);
    }
    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Vendor by Category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the vendors by category",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VendorListDTO.class))}
            ),
            @ApiResponse(responseCode = "400", description = "Invalid Category supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Vendor not found",
                    content = @Content)
    }
    )
    public VendorDTO getVendorByCategory(@PathVariable String category){
        return vendorService.getVendorByCategory(category);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Vendor by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the vendor by id",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VendorDTO.class))}
            ),
            @ApiResponse(responseCode = "400", description = "Invalid Id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Vendor not found",
                    content = @Content)
    }
    )
    public VendorDTO getVendorById(@PathVariable Long id){
        return vendorService.getVendorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Vendor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vendor Created correctly",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VendorDTO.class))}
            ),
            @ApiResponse(responseCode = "400", description = "Invalid Vendor parameters",
                    content = @Content),

    }
    )
    public VendorDTO createVendor(@RequestBody VendorDTO vendorDTO){
        return vendorService.createVendor(vendorDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update Vendor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vendor updated correctly",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VendorDTO.class))}
            ),
            @ApiResponse(responseCode = "400", description = "Invalid Vendor parameters",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Vendor not found",
                    content = @Content)
    }
    )
    public VendorDTO updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return vendorService.updateVendor(id, vendorDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete Vendor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vendor deleted correctly",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VendorDTO.class))}
            ),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Vendor not found",
                    content = @Content)
    }
    )
    public Long deleteVendor(@PathVariable Long id){
        return vendorService.deleteVendor(id);
    }
}
