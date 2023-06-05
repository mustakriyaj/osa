package com.project.osa.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Data
@Getter
@Setter
public class AddToCartReqestDto {
    private Integer customerId;
    private Integer productId;
    private int quantity;
}
