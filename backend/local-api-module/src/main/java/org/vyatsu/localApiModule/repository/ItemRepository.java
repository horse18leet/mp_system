package org.vyatsu.localApiModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.vyatsu.localApiModule.entity.item.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByUserId(Long id);

    @Query("SELECT DISTINCT i.category FROM Item i WHERE i.user.id = ?1")
    List<String> findUniqueCategoryByUserId(Long id);
}
