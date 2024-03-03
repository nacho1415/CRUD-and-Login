package com.example.crud.Repository;

import com.example.crud.Domain.User;
import com.example.crud.UserDto.UserDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public User createUser (UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setNickname(userDto.getNickname());
        em.persist(user);
        return user;
    }

    public int countUser () {
        List<User> users = em.createQuery("SELECT u From User u").getResultList();
        return users.size();
    }

    public User save (User user) {
        em.persist(user);
        return user;
    }

    public List<User> findAll () {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }
}
