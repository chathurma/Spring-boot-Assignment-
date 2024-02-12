package com.isej.ISEJ.service;

import com.isej.ISEJ.api.Entitiy.ItemCategory;
import com.isej.ISEJ.api.repository.Item_CategoryRepository;
import com.isej.ISEJ.api.request.ItemCategoryRequest;
import com.isej.ISEJ.api.response.ItemCategoryResponse;
import com.isej.ISEJ.api.utils.ItemCategoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemCategoryService {
    @Autowired
    private Item_CategoryRepository itemCategoryRepository;
    //GET
    public List<ItemCategoryResponse> getAllItemCategories() {
        List<ItemCategoryResponse> ItemCategoryResponseList = new ArrayList<>();
        List<ItemCategory> ItemCategoryList = itemCategoryRepository.findAll();
        for (ItemCategory ItemCategory : ItemCategoryList) {
           ItemCategoryResponse ItemCategoryResponse = ItemCategoryUtils.mapToResponse(ItemCategory);
            ItemCategoryResponseList.add(ItemCategoryResponse);
        }
        return ItemCategoryResponseList;
    }
    //POST
    public ItemCategoryResponse addItemCategory(ItemCategoryRequest ItemCategoryReq) {
        ItemCategory itemCategory = ItemCategory.builder()
                .id (ItemCategoryReq.getId())
                .categoryCode(ItemCategoryReq.getCategoryCode())
                .description(ItemCategoryReq.getDescription())
                .build();
        return ItemCategoryUtils.mapToResponse(itemCategoryRepository.save(itemCategory));
    }

    //PUT
    public ItemCategoryResponse updateItemCategory(Integer id, ItemCategoryRequest ItemCategoryReq) {
        ItemCategory itemCategory = itemCategoryRepository.findById(id).orElse(null);
        itemCategory.setCategoryCode(ItemCategoryReq.getCategoryCode());
        itemCategory.setDescription(ItemCategoryReq.getDescription());
        return ItemCategoryUtils.mapToResponse(itemCategoryRepository.save(itemCategory));
    }

    //DELETE
    public ItemCategoryResponse deleteItemCategory(Integer id) {
        ItemCategory itemCategory = itemCategoryRepository.findById(id).orElse(null);
        itemCategoryRepository.delete(itemCategory);
        return ItemCategoryUtils.mapToResponse(itemCategory);
    }
}
