package com.eronrodrigo.shopingcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter  @NoArgsConstructor  @AllArgsConstructor
public class Item {
    private ProductOverview product;
    private int quantity;
}