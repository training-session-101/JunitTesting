package unittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unittest.data.Product;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Override
    default List<Product> findAll(){
        return Arrays.asList(new Product(1,"Product1"));
    }
}
