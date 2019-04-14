package unittest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import unittest.data.Item;
import unittest.service.ItemService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //loads the application context
@WebMvcTest(ItemController.class) //loads the context with ItemController only
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService; //mock the service depedency

    @Test
    public void shouldReturnOKStatus() throws Exception{
        Mockito.when(itemService.getItemById(1)).thenReturn(new Item(1,"Item1",12,25));
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/item?id=1").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json("{" +
                "id:1,name:Item1,price:12,quantity:25}"));
    }

    @Test
    public void shouldAddItems() throws Exception{
        String newItemRequest="{\"name\":\"Item1\",\n" +
                "\"value\":23,\"price\":79}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/item").content(newItemRequest).contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteItem() throws Exception{
        RequestBuilder requestBuilder=MockMvcRequestBuilders.delete("/item?id=1").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }
}
