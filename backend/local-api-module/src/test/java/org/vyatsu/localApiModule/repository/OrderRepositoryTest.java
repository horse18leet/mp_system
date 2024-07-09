package org.vyatsu.localApiModule.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.vyatsu.localApiModule.entity.item.Order;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    OrderRepository repository;

    @Test
    public void findOrdersByItemId() {
        Long itemId = 21L;
        List<Order> orders = repository.findOrdersByItemId(itemId);
        Assert.assertNotNull(orders);
    }

    @Test
    public void existsBySrid() {
        String srid = "5b161f94e60445b488c4b52dbf64b246";
        boolean sridIsExists = repository.existsBySrid(srid);
        Assert.assertTrue(sridIsExists);
    }

    @Test
    public void findBySrid() {
        String srid = "5b161f94e60445b488c4b52dbf64b246";
        Order order = repository.findBySrid(srid);
        Assert.assertNotNull(order);
    }

    @Test
    public void findOrdersByUserAndCreatedAtBetween() {
        Long userId = 1L;
        LocalDateTime dateFrom = LocalDateTime.parse("2024-06-01T00:00:00");
        LocalDateTime dateTo = LocalDateTime.parse("2024-06-18T00:00:00");
        List<Order> orders = repository.findOrdersByUserAndCreatedAtBetween(userId, dateFrom, dateTo);
        Assert.assertNotNull(orders);
    }
}