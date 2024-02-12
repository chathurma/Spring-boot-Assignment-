package com.isej.ISEJ.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {

        private Integer id;
        private String name;
        private String categoryCode;
        private String description;
        private Double price;
        private Integer quantity;

}
