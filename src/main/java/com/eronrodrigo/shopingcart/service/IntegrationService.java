package com.eronrodrigo.shopingcart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eronrodrigo.shopingcart.model.Item;
import com.eronrodrigo.shopingcart.model.UserInfo;

import lombok.AllArgsConstructor;
import lombok.var;

@Service
@AllArgsConstructor
public class IntegrationService { 
	private final UserFeignClient userFeignClient;
    private final ProductFeignClient productFeignClient;
    
    public UserInfo getRemoteUserInfo(Long userId) { 
    	var user = userFeignClient.findById(userId);

        return user;
    }

    public List<Item> getRemoteProductItemsInfo(List<Item> items) {
    	items.forEach(item -> {

            var product = productFeignClient.findById(item.getProduct().getId());

            item.setProduct(product);
        });

        return items;
    }
}