package unittest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unittest.data.Item;
import unittest.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item getItemById(Integer id){
        return itemRepository.findOneById(id);
    }

    @Transactional
    public Item addItem(Item item) {
      return itemRepository.save(item);
    }

    @Transactional
    public Item deleteItem(int id) {
        Item item=itemRepository.findOneById(id);
        itemRepository.deleteById(id);
        return item;
    }
}