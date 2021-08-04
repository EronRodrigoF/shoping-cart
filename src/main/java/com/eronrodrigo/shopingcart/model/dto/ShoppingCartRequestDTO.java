package com.eronrodrigo.shopingcart.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor  @NoArgsConstructor
@Getter  @Setter
public class ShoppingCartRequestDTO { 
    private Long userId;
    private List<ItemDTO> items;
}