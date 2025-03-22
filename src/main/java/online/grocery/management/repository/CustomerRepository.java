package online.grocery.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import online.grocery.management.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    // custom query method 
    // it works line find where name == given name 
    List<Customer> findByName(String name);


}
