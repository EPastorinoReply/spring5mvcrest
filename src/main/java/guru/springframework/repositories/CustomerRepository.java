package guru.springframework.repositories;

import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByFirstname(String firstname);
}
