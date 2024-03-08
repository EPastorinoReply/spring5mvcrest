package guru.springframework.domain;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category = new Category(1L, "Telecommunication");
//    @Before("")
//    public void setUp()
//    {
//
//
//
//    }
    @Test
    void getId() {
        assertEquals(1L, category.getId());
    }

    @Test
    void getName() {
        assertEquals("Telecommunication", category.getName());
    }
    @Test
    void setId() {
        category.setId(2L);
        assertEquals(2L, category.getId());
    }

    @Test
    void setName() {
        category.setName("Telcom");
//        assertThrows(Exception.class, category.setName());
        assertEquals("Telcom", category.getName());
    }



}