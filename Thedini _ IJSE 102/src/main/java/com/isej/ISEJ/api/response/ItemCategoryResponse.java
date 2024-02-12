package com.isej.ISEJ.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCategoryResponse {
    private Integer id;
    private String categoryCode;
    private String description;
}
