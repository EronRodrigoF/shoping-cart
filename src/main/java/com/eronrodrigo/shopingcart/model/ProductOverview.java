package com.eronrodrigo.shopingcart.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  @NoArgsConstructor  @AllArgsConstructor
public class ProductOverview {
    private Long id;
    private String name;
    private BigDecimal price;

    public BigDecimal getPrice() {
        if (price == null)
            price = BigDecimal.ZERO;
        return price;
    }
}