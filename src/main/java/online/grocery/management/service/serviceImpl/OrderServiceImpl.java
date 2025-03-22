package online.grocery.management.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.grocery.management.DTO.OrderRequest;
import online.grocery.management.exception.ResourceNotFoundException;
import online.grocery.management.model.Customer;
import online.grocery.management.model.GroceryItem;
import online.grocery.management.model.Order;
import online.grocery.management.repository.CustomerRepository;
import online.grocery.management.repository.GroceryItemRepository;
import online.grocery.management.repository.OrderRepository;
import online.grocery.management.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private GroceryItemRepository groceryRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getAllOrders'");
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getOrderById'");
    }

    @Override
    public void deleteOrder(Integer Id) {
        Order order=getOrderById(Id);
        orderRepo.delete(order);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'deleteOrder'");
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
           Customer customer = customerRepo.findById(orderRequest.getCustomer_id())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + orderRequest.getCustomer_id()));
        List<GroceryItem> groceryItem = groceryRepo.findAllById(orderRequest.getItem_id());
        
        if (groceryItem.size() != orderRequest.getItem_id().size()) {
            throw new ResourceNotFoundException("One or more products not found");
        }
        Order order=new Order();
        order.setCustomer(customer);
        order.setGroceryItem(groceryItem);
        order.setOrderDate(LocalDateTime.now());
       return orderRepo.save(order);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }
    
}
