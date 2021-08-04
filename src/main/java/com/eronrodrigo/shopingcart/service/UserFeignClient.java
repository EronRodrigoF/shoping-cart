package com.eronrodrigo.shopingcart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eronrodrigo.shopingcart.model.UserInfo;

@FeignClient(url = "http://localhost:8082/api/user/", name = "UserInformationService")
public interface UserFeignClient { 
    @GetMapping("/api/user/{id}")
    UserInfo findById(@PathVariable("id") Long id); 
}