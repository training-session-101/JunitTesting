package unittest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import unittest.dto.ProductDetails;
import unittest.repository.ProductRepository;
import unittest.service.ProductService;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({ProductController.class, ProductRepository.class})
public class ProductControllerTest {

    @MockBean
    private ProductService productService;


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnOKStatus() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void shouldReturnAllProductDetails_whenGetAllProductDetailsIsCalled() throws Exception {
        when(productService.getAllProductDetails()).thenReturn(singletonList(new ProductDetails(1, "Product1")));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json("[{\"productId\":1,\"productName\":\"Product1\"}]"));
    }

   /*@Test
    public void shouldReturnAllProductDetails_whenGetAllProductDetailsIsCalledWithSpy() throws Exception {
        when(productService.getAllProductDetails()).thenCallRealMethod();
        when(productRepository.findAll()).thenCallRealMethod();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json("[{\"productId\":1,\"productName\":\"Product1\"}]"));
    }*/

}
