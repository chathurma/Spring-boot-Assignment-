package com.isej.ISEJ.api.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class stockResponse {

    private Integer id;
    private String name;
    private String price;
    private String visibility;
    private String quantity;
    private String description;
    private String image;
}
