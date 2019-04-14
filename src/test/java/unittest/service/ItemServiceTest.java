package unittest.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import unittest.data.Item;
import unittest.repository.ItemRepository;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void shouldReturnItemWithId1(){
        Mockito.when(itemRepository.findOneById(1)).thenReturn(new Item(1,"Item1",23,12));
        assertEquals(itemService.getItemById(1), new Item(1,"Item1",23,12));
    }

    @Test
    public void shouldAddItem(){
        Item item = new Item(1,"Item1",23,45);
        itemService.addItem(item);
        Mockito.verify(itemRepository,Mockito.times(1)).save(item);
    }

    @Test
    public void shouldDeleteItemItem(){
        itemService.deleteItem(1);
        Mockito.verify(itemRepository,Mockito.times(1)).deleteById(1);
    }
}
