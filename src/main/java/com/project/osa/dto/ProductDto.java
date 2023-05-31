package com.project.osa.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Data
@Getter
@Setter
public class ProductDto {

    private String productName;

    private String price;

    private String manufacturer;

    private Integer categoryId;
}
