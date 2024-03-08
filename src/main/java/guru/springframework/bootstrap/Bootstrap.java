package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 9/24/17.
 */
@Component
public class Bootstrap implements CommandLineRunner{

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("Category Data Loaded = " + categoryRepository.count() );


        Customer c1 = new Customer();
        c1.setFirstname("Eddy");

        Customer c2 = new Customer();
        c2.setFirstname("Kamal");

        Customer c3 = new Customer();
        c3.setFirstname("Fabrizio");

        Customer c4 = new Customer();
        c4.setFirstname("Giovanni");

        Customer c5 = new Customer();
        c5.setFirstname("Matteo");

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);
        customerRepository.save(c5);


        System.out.println("Customer Data Loaded = " + customerRepository.count() );

        Vendor v1 = new Vendor();
        v1.setName("Unicredit");

        Vendor v2 = new Vendor();
        v2.setName("BPM");

        Vendor v3 = new Vendor();
        v3.setName("Generali");

        Vendor v4 = new Vendor();
        v4.setName("Credit Agricole");

        Vendor v5 = new Vendor();
        v5.setName("Findomestic");

        vendorRepository.save(v1);
        vendorRepository.save(v2);
        vendorRepository.save(v3);
        vendorRepository.save(v4);
        vendorRepository.save(v5);


        System.out.println("Vendor Data Loaded = " + vendorRepository.count() );

    }
}