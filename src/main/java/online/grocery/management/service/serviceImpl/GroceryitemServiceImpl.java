package online.grocery.management.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.grocery.management.exception.ResourceNotFoundException;
import online.grocery.management.model.GroceryItem;
import online.grocery.management.repository.GroceryItemRepository;
import online.grocery.management.service.GroceryItemService;

@Service
public class GroceryitemServiceImpl implements GroceryItemService{

    @Autowired
    private GroceryItemRepository groceryRepo;
    @Override
    public List<GroceryItem> getAllGroceryItem() {

       return groceryRepo.findAll();
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getAllGroceryItem'");
    }

    @Override
    public GroceryItem getGroceryItemById(Integer id) {
       
       // optional contains null values 

        return groceryRepo.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("No item with id :"+id));

        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getGroceryItemById'");
    }

    @Override
    public GroceryItem createGroceryItem(GroceryItem groceryItem) {
        return groceryRepo.save(groceryItem);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'createGroceryItem'");
    }

    @Override
    public GroceryItem getGroceryItemByName(String  grocery_item) {

        return groceryRepo.findByGroceryItem(grocery_item);
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getGroceryItemByName'");
    }

    @Override
    public GroceryItem updateGroceryitem(Integer id, GroceryItem groceryItemdetails) {
        GroceryItem groceryItem=getGroceryItemById(id);
        groceryItem.setCategory(groceryItemdetails.getCategory());
        groceryItem.setGrocery_item(groceryItemdetails.getGrocery_item());
        groceryItem.setItemQuantity(groceryItemdetails.getItemQuantity());
        groceryItem.setPrice(groceryItemdetails.getPrice());
        return groceryRepo.save(groceryItem);


        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'updateGroceryitem'");
    }

    @Override
    public void deleteGroceryItem(Integer id) {

         GroceryItem groceryItem=getGroceryItemById(id);
         groceryRepo.delete(groceryItem);        
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'deleteGroceryItem'");
    }

    @Override
    public void deleteGroceryitem(String name) {

        GroceryItem groceryItem=getGroceryItemByName(name);
        groceryRepo.delete(groceryItem);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'deleteGroceryitem'");
    }
    
}
