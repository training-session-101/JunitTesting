package unittest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unittest.data.Item;
import unittest.data.ItemRequest;
import unittest.service.ItemService;

@RestController
public class ItemController {

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    private ItemService itemService;


    @GetMapping("/item")
    public Item getItem(Integer id){
        return itemService.getItemById(id);
    }

    @PostMapping("/item")
    public void addItem(@RequestBody ItemRequest itemRequest){
        Item item = new Item(itemRequest.getName(),itemRequest.getPrice(),itemRequest.getValue());
        itemService.addItem(item);
    }

    @DeleteMapping("/item")
    public void addItem(@RequestParam("id") Integer id){
        itemService.deleteItem(id);
    }
}
