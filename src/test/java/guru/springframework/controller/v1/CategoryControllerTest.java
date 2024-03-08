package guru.springframework.controller.v1;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CategoryListDTO;
import guru.springframework.controllers.v1.CategoryController;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.services.CategoryService;
import guru.springframework.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryControllerTest {
    String NAME = "Finance";
    Long ID = 2L;
    CategoryService categoryService = Mockito.mock(CategoryService.class);
    CategoryController categoryController = new CategoryController(categoryService);

    @Test
    public void getAllCategories() {
        //given
        List<CategoryDTO> categories = Arrays.asList(new CategoryDTO(), new CategoryDTO(), new CategoryDTO());
        when(categoryService.getAllCategories()).thenReturn(categories);
        //when
        CategoryListDTO categoryList = categoryController.getAllCategories();
        //then
        assertEquals(3, categoryList.getCategories().size());

    }

    @Test
    public void getCategoryByName() {
        CategoryDTO cat = new CategoryDTO();
        cat.setName(NAME);
        cat.setId(ID);
        when(categoryService.getCategoryByName(anyString())).thenReturn(cat);
        CategoryDTO categoryDTO = categoryController.getCategoryByName(NAME);
        assertEquals(NAME, categoryDTO.getName());
        assertEquals(ID, categoryDTO.getId());
    }
}
