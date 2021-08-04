package com.eronrodrigo.shopingcart.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.eronrodrigo.shopingcart.model.Cart;
import com.eronrodrigo.shopingcart.model.Item;
import com.eronrodrigo.shopingcart.model.UserInfo;

import lombok.AllArgsConstructor;
import lombok.var;

@Service
@AllArgsConstructor
public class ShoppingCartService { 
    private IntegrationService integrationService;

    public Cart purchase(Cart shoppingCart) {
        var uuid = UUID.randomUUID().toString();
        shoppingCart.setId(uuid);

        UserInfo user = integrationService.getRemoteUserInfo(shoppingCart.getUser().getId());
        shoppingCart.setUser(user);

        List<Item> items = integrationService.getRemoteProductItemsInfo(shoppingCart.getItems());
        shoppingCart.setItems(items);

        return shoppingCart;
    }
}
