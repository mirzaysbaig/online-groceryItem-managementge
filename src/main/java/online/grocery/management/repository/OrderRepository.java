package online.grocery.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import online.grocery.management.model.Order;


public interface OrderRepository extends JpaRepository<Order,Integer> {
    
}
