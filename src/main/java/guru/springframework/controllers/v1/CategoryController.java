package guru.springframework.controllers.v1;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CategoryListDTO;
import guru.springframework.domain.Category;
import guru.springframework.services.CategoryService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all categories")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found all the categories",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = CategoryListDTO.class))}
            )

        }
    )
    public CategoryListDTO getAllCategories(){

        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get category by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the category by name",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDTO.class))}
            ),
            @ApiResponse(responseCode = "400", description = "Invalid Name supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Category not found",
                    content = @Content)
        }
    )
    public CategoryDTO getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
}