package com.example.crud.User;

import com.example.crud.Domain.User;
import com.example.crud.Repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void 유저전체조회 () {
        int users = userRepository.findAll().size();
        Assertions.assertThat(users).isEqualTo(2);
    }
}
