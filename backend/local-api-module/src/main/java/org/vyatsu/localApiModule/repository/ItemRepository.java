package org.vyatsu.localApiModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.entity.item.Item;
import org.vyatsu.localApiModule.entity.user.User;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByUserId(Long id);

    List<Item> findItemByUserAndIsDraft(User user, boolean isDraft);

    @Query("SELECT DISTINCT i.category FROM Item i WHERE i.user.id = ?1")
    List<String> findUniqueCategoryByUserId(Long id);

    Item findByVendorCode(String vendorCode);


    List<Item> findItemByIsDraft(Boolean isDraft);
}
