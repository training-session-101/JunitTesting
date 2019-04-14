package unittest.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import unittest.controller.ItemController;
import unittest.data.Item;
import unittest.service.ItemService;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest // loads the data from data.sql file
@RunWith(SpringRunner.class)
//@WebMvcTest(ItemController.class)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    //@MockBean
    //private ItemService itemService;

    //@Autowired
    //private MockMvc mockMvc;

    @Test
    public void ItemRepositoryShouldHave3Values(){
        assertEquals(itemRepository.findAll().size(),3);
    }

    /*@Test
    public void shouldRevertBackTransaction() throws Exception{
        long noOfEntries = itemRepository.count();
        //Mockito.when(itemService.deleteItem(1)).thenThrow(new RuntimeException());
        //Mockito.when(itemRepository.findOneById(1)).thenReturn(new Item(1,"Item1",23,45));
        RequestBuilder requestBuilder= MockMvcRequestBuilders.delete("/item?id=1").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
        assertEquals(noOfEntries,itemRepository.count());
    }*/


}
