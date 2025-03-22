package online.grocery.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import online.grocery.management.model.Customer;
import online.grocery.management.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService CustomerService;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Integer id){
        return CustomerService.getCustomerbyId(id);
    }
     
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return CustomerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Integer id,@RequestBody Customer customer){
        Customer updatedCustomer =CustomerService.updateCustomer(id, customer);
        return ResponseEntity.ok().build();
    }

    
}
