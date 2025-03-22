package online.grocery.management.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.grocery.management.exception.ResourceNotFoundException;
import online.grocery.management.model.Customer;
import online.grocery.management.repository.CustomerRepository;
import online.grocery.management.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepo.findAll();
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getAllCustomers'");
    }

    @Override
    public Customer getCustomerbyId(Integer id) {
        return customerRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Customer not found with id:"+id));
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getCustomerbyId'");
    }
    
    @Override
    public List<Customer> getCustomerByName(String name) {

        return customerRepo.findByName(name);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getCustomerByName'");
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'createCustomer'");
    }

    @Override
    public Customer updateCustomer(int id, Customer customerDetails) {
        Customer customer=getCustomerbyId(id);
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
         return customerRepo.save(customer);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
    }

    @Override
    public void deleteCustomer(int id) {
         Customer customer=getCustomerbyId(id);
         customerRepo.delete(customer);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
    }

    @Override // return all the customer with that particular name 
    public void deleteCustomer(String name) {
        // getting customer bby name 
        List<Customer> customer=getCustomerByName(name);

        for(int i=0;i<customer.size();i++)
        customerRepo.delete(customer.get(i));
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
    }

   
    
}
