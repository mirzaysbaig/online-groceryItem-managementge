package online.grocery.management.service;

import java.util.List;

import online.grocery.management.model.GroceryItem;

public interface GroceryItemService {
    List<GroceryItem> getAllGroceryItem();
    GroceryItem getGroceryItemById(Integer id);
    GroceryItem createGroceryItem(GroceryItem groceryItem);
    GroceryItem getGroceryItemByName(String name);
    GroceryItem updateGroceryitem(Integer id,GroceryItem groceryItemdetails);
   // Double getGroceryItemPrice(Integer id);
    void deleteGroceryItem(Integer id);
    void deleteGroceryitem(String name);
}    
