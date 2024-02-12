package com.isej.ISEJ.api.utils;

import com.isej.ISEJ.api.Entitiy.Item;
import com.isej.ISEJ.api.response.ItemResponse;

public class ItemUtils {
    public static ItemResponse mapToResponse(Item item) {
        return ItemResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .categoryCode(item.getCategoryCode())
                .description(item.getDescription())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .build();
    }
}
