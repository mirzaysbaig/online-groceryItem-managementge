package online.grocery.management.service;

import java.util.List;

import online.grocery.management.DTO.OrderRequest;
import online.grocery.management.model.Order;

public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(Integer id);
    void deleteOrder(Integer Id);
    Order createOrder(OrderRequest orderRequest);
}
