package com.dg.bsm.inventory.controller;

import com.dg.bsm.inventory.domain.InventoryInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("inventory")
public class InventoryController {


    @GetMapping("/books/{bookId}")
    public InventoryInfo getInventoryInfoByItemId(@PathVariable String bookId){
        return new InventoryInfo(bookId, true, new Random().nextInt(1,10));
    }
}
