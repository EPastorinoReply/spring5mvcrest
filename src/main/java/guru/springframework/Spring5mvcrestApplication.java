package guru.springframework;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories
@OpenAPIDefinition(tags = {
		@Tag(name = "CategoryController", description = "Controller for managing the operation on different categories"),
		@Tag(name = "CustomerController", description = "Controller for managing the operation on different customers"),
		@Tag(name = "VendorController", description = "Controller for managing the operation on different vendors")})
public class Spring5mvcrestApplication {
	private String bella = "Bella!!";
	public static void main(String[] args) {
		SpringApplication.run(Spring5mvcrestApplication.class, args);
	}

}
