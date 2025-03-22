package online.grocery.management.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="customer_order")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Order {
 @Id
 @GeneratedValue   
 private int order_id;

 private LocalDateTime orderDate;

 // many to one relation with customer 
 @ManyToOne
 @JoinColumn(name="customer_id")
 private Customer customer;

 // many to many relation with grocery item 
 @ManyToMany
 @JoinTable(name="order_item",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="groceryitem_id")    
    )
 private List<GroceryItem> groceryItem=new ArrayList<>();
 
 
    
}
