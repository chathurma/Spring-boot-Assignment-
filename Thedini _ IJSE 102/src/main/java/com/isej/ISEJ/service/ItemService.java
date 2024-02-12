package com.isej.ISEJ.service;

import com.isej.ISEJ.api.Entitiy.Item;
import com.isej.ISEJ.api.repository.ItemRepository;
import com.isej.ISEJ.api.request.ItemRequest;
import com.isej.ISEJ.api.response.ItemResponse;
import com.isej.ISEJ.api.response.UserResponse;
import com.isej.ISEJ.api.utils.ItemUtils;
import com.isej.ISEJ.api.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    //GET
    public List<ItemResponse> getItems() {
        List<ItemResponse> itemResponsesList = new ArrayList<>();
        List<Item> itemsList = itemRepository.findAll();
        for (Item item : itemsList) {
            ItemResponse itemResponse = ItemUtils.mapToResponse(item);
            itemResponsesList.add(itemResponse);
        }
        return itemResponsesList;
    }
    //GET THE ITEM BY QUANTITY IS NOT ZERO
    public List<ItemResponse> getItemsByQuantity() {
        List<ItemResponse> itemResponsesList = new ArrayList<>();
        List<Item> itemsList = itemRepository.findAll();
        for (Item item : itemsList) {
            if (item.getQuantity() != 0) {
                ItemResponse itemResponse = ItemUtils.mapToResponse(item);
                itemResponsesList.add(itemResponse);
            }
        }
        return itemResponsesList;
    }
    //GET BY ID
    public ItemResponse getItemById(Integer id) {
       try{
           Item item = itemRepository.findById(id).orElse(null);
           if (item == null) {
               return null;
           }else {
               return ItemUtils.mapToResponse(itemRepository.getReferenceById(id));

           }
       }
       catch (Exception e){
           System.out.println(e);
           return null;
       }
    }
    //POST
    public ItemResponse addItem(ItemRequest itemReq) {
        Item item = Item.builder()
                .name(itemReq.getName())
                .categoryCode(itemReq.getCategoryCode())
                .description(itemReq.getDescription())
                .price(itemReq.getPrice())
                .quantity(itemReq.getQuantity())
                .build();
        return ItemUtils.mapToResponse(itemRepository.save(item));

    }
    //PUT
    public ItemResponse updateItem(Integer id, ItemRequest itemReq) {
        Item item = itemRepository.findById(id).orElse(null);
        item.setName(itemReq.getName());
        item.setCategoryCode(itemReq.getCategoryCode());
        item.setDescription(itemReq.getDescription());
        item.setPrice(itemReq.getPrice());
        item.setQuantity(itemReq.getQuantity());
        return ItemUtils.mapToResponse(itemRepository.save(item));
    }

    //DELETE
    public ItemResponse deleteItem(Integer id) {
        Item item = itemRepository.findById(id).orElse(null);
        itemRepository.deleteById(id);
        return ItemUtils.mapToResponse(item);
    }

}
