package guru.springframework.repositories;

import guru.springframework.Spring5mvcrestApplication;
import guru.springframework.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.*;
//@DataJpaTest
@SpringBootTest(classes = Spring5mvcrestApplication.class)
@ComponentScan(basePackages = "guru.springframework")
//@ExtendWith(SpringExtension.class)
class CategoryRepositoryTestIT {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void findByName() {
//        Category cat = new Category();
//        cat.setName("ciao");
//        cat.setId(4L);
//        Category category = categoryRepository.findByName("ciao");
//        assertEquals("ciao", cat.getName());
    }
}