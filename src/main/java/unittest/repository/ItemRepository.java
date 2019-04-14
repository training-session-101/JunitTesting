package unittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unittest.data.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    Item findOneById(Integer id);
}
