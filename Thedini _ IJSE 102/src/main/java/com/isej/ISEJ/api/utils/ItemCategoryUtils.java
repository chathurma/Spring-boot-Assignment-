package com.isej.ISEJ.api.utils;

import com.isej.ISEJ.api.Entitiy.ItemCategory;
import com.isej.ISEJ.api.response.ItemCategoryResponse;

public class ItemCategoryUtils {
    public static ItemCategoryResponse mapToResponse(ItemCategory itemCategory) {
        return ItemCategoryResponse.builder()
                .id(itemCategory.getId())
                .categoryCode(itemCategory.getCategoryCode())
                .description(itemCategory.getDescription())
                .build();
    }
}
