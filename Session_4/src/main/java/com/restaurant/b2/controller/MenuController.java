package com.restaurant.b2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @GetMapping("/bai2/menu")
    public String getMenu(
            @RequestParam(
                    value = "category",
                    required = false,
                    defaultValue = "chay"
            ) String category
    ) {
        return "Thuc don hien tai: " + category;
    }
}