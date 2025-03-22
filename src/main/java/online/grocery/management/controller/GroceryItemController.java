package online.grocery.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.grocery.management.model.GroceryItem;
import online.grocery.management.service.GroceryItemService;
import online.grocery.management.service.serviceImpl.GroceryitemServiceImpl;

@RestController
@RequestMapping("/api/groceryItem")
public class GroceryItemController {
    
    @Autowired
    private GroceryItemService groceryservice;

    @GetMapping
    public List<GroceryItem> getAllGroceryItem(){
        return groceryservice.getAllGroceryItem();
    }

    @GetMapping("/{id}")
    public GroceryItem getItemById(@PathVariable Integer id){
        return groceryservice.getGroceryItemById(id);
    }

    @GetMapping("/{name}")
    public GroceryItem getByName(@PathVariable String name){
        return groceryservice.getGroceryItemByName(name);
    }
    
    // @GetMapping("/{price}")
    // public int getGroceryItemPrice(@PathVariable Integer id){
    //     return groceryservice.get
    // }

    @PostMapping
    public GroceryItem createItem(@RequestBody GroceryItem groceryItem){
        return groceryservice.createGroceryItem(groceryItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateItem(@PathVariable Integer id, @RequestBody GroceryItem groceryItem){
        GroceryItem gritem=groceryservice.updateGroceryitem(id, groceryItem);
        return ResponseEntity.ok().build();


    }
      @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        groceryservice.deleteGroceryItem(id);
        return ResponseEntity.ok().build();
    }



}
