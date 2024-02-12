package com.isej.ISEJ.api.utils;

import  com.isej.ISEJ.api.Entitiy.stock;
import  com.isej.ISEJ.api.request.stockRequest;
import  com.isej.ISEJ.api.response.stockResponse;

public class stockUtils {
    public static stockResponse mapToResponse(stock stock) {
        return stockResponse.builder()
                .id(stock.getId())
                .name(stock.getName())
                .price(stock.getPrice())
                .visibility(stock.getVisibility())
                .quantity(stock.getQuantity())
                .description(stock.getDescription())
                .image(stock.getImage())
                .build();
    }
}
