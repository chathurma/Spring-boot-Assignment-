package com.isej.ISEJ.api.controller;

import com.isej.ISEJ.api.request.ItemRequest;
import com.isej.ISEJ.api.request.UserRequest;
import com.isej.ISEJ.api.response.ItemResponse;
import com.isej.ISEJ.api.response.UserResponse;
import com.isej.ISEJ.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
    @Autowired
    private ItemService itemService;

    //GET
    @GetMapping("/items")
    public List<ItemResponse> getItems() {
        return itemService.getItems();
    }
    //GET THE ITEM BY QUANTITY IS NOT ZERO
    @GetMapping("/items/quantity")
    public List<ItemResponse> getItemsByQuantity() {
        return itemService.getItemsByQuantity();
    }
    //GET BY ID
    @GetMapping("/items/{id}")
    public ItemResponse getItemById(@PathVariable Integer id) {
        return itemService.getItemById(id);
    }
    //POST
    @PostMapping("/addItems")
    public ItemResponse addItems(@RequestBody ItemRequest itemReq) {
        try{
            return itemService.addItem(itemReq);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    //PUT
    @PutMapping("/updateItems/{id}")
    public ItemResponse updateItems(@PathVariable Integer id, @RequestBody ItemRequest itemReq) {
        return itemService.updateItem(id, itemReq);
    }

    //DELETE
    @DeleteMapping("/deleteItems/{id}")
    public ItemResponse deleteItems(@PathVariable  Integer id) {
        return itemService.deleteItem(id);
    }


}
