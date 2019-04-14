package unittest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unittest.data.Product;
import unittest.dto.ProductDetails;
import unittest.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDetails> getAllProductDetails(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(x-> new ProductDetails(x.getId(),x.getName())).collect(Collectors.toList());
    }
}
