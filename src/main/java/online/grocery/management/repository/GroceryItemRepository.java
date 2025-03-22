package online.grocery.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import online.grocery.management.model.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem,Integer>{
   // custom querry
    GroceryItem findByGroceryItem(String grocery_item);
}
