package com.isej.ISEJ.api.controller;

import com.isej.ISEJ.api.request.ItemCategoryRequest;
import com.isej.ISEJ.api.response.ItemCategoryResponse;
import com.isej.ISEJ.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;

    //GET
    @GetMapping("/itemCategories")
    public List<ItemCategoryResponse> getAllItemCategories() {
        return itemCategoryService.getAllItemCategories();
    }

    //POST
    @PostMapping("/addItemCategory")
    public ItemCategoryResponse addItemCategory(@RequestBody ItemCategoryRequest itemCategoryReq){
        return itemCategoryService.addItemCategory(itemCategoryReq);
    }

    //PUT
    @PutMapping("/updateItemCategory/{id}")
    public ItemCategoryResponse updateItemCategory(@PathVariable Integer id, @RequestBody ItemCategoryRequest itemCategoryReq){
        return itemCategoryService.updateItemCategory(id, itemCategoryReq);
    }

    //DELETE
    @DeleteMapping("/deleteItemCategory/{id}")
    public ItemCategoryResponse deleteItemCategory(@PathVariable Integer id){
        return itemCategoryService.deleteItemCategory(id);
    }


}
