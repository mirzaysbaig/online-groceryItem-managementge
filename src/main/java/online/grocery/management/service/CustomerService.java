package online.grocery.management.service;

import java.util.List;

import online.grocery.management.model.Customer;

public interface CustomerService {
        List<Customer> getAllCustomers();
        Customer getCustomerbyId(Integer id);
        Customer createCustomer(Customer customer);
        Customer updateCustomer(int id,Customer customerDetails);
        void deleteCustomer(int id);
        void deleteCustomer(String name);
        List<Customer> getCustomerByName(String name);
}
