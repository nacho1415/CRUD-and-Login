package com.example.crud.Repository;

import com.example.crud.Domain.User;
import com.example.crud.Dto.UserDto.CreateUserDto;
import com.example.crud.Dto.UserDto.SignupDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

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

    public boolean DuplicateNicknameCheck (String nickname) {
        Long count = em.createQuery("SELECT COUNT(u) FROM User u WHERE u.userName = :nickname", Long.class)
                .setParameter("nickname", nickname)
                .getSingleResult();
        return count > 0;
    }
}
