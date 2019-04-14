package unittest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import unittest.data.Product;
import unittest.dto.ProductDetails;
import unittest.repository.ProductRepository;

import java.util.Arrays;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;

    //@Spy
    @Mock
    private ProductRepository productRepository;

    @Test
    public void shouldReturnAllProducts_whenGetAllProductsIsCalled(){
        //when(productRepository.findAll()).thenReturn(Arrays.asList(new Product(1,"Product1")));
        when(productRepository.findAll()).thenCallRealMethod();
        assertThat(productService.getAllProductDetails()).isEqualTo(singletonList(new ProductDetails(1, "Product1")));
    }
}
