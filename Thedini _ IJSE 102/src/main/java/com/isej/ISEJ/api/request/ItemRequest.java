package com.isej.ISEJ.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

        private Integer id;
        private String name;
        private String categoryCode;
        private String description;
        private Double price;
        private Integer quantity;
}
