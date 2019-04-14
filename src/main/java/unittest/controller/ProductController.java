package unittest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unittest.dto.ProductDetails;
import unittest.service.ProductService;

import java.util.List;

@RestController("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDetails> getAllProductDetails(){
        return productService.getAllProductDetails();
    }
}
