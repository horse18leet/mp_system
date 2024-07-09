package org.vyatsu.localApiModule.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.vyatsu.localApiModule.entity.user.User;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UserRepository repository;

    @Test
    public void should_find_all_users() {
        List<User> users = repository.findAll();
        Assert.assertNotNull(users);
    }

    @Test
    public void should_find_user_by_email() {
        String email = "gluhih20003@mail.ru";
        Optional<User> user = repository.findByEmail(email);
        Assert.assertNotNull(user);
    }
}