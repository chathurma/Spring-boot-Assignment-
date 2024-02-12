package com.isej.ISEJ.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCategoryRequest {
    private Integer id;
    private String categoryCode;
    private String description;
}
