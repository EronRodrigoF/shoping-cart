package com.eronrodrigo.shopingcart.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter  @NoArgsConstructor  @AllArgsConstructor
public class Cart {
    private String id;
    private UserInfo user;
    private List<Item> items;
    private BigDecimal totalPrice;

    public Cart(String id, UserInfo user, List<Item> items) {
        this(id, user, items, BigDecimal.ZERO);
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        if (items == null) return;
        totalPrice = items.stream()
            .map(item -> item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalPrice() {
        calculateTotalPrice();
        return totalPrice;
    }
}
