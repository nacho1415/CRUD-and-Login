package com.example.crud.Repository;

import com.example.crud.Domain.User;
import com.example.crud.Dto.UserDto.CreateUserDto;
import com.example.crud.Dto.UserDto.SignupDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class UserRepository {

    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    EntityManager em;



    @Autowired
    public UserRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
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

    public boolean DuplicateNicknameCheck (String nickname) {
        Long count = em.createQuery("SELECT COUNT(u) FROM User u WHERE u.nickname = :nickname", Long.class)
                .setParameter("nickname", nickname)
                .getSingleResult();
        return count > 0;
    }

    public User findByEmail (String email) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            // 해당 이메일을 가진 사용자를 찾지 못한 경우
            return null;
        }
    }

    public Boolean isSamePassword (String inputPassword, String databasePassword) {
        String encryptionPassword = passwordEncoder.encode(inputPassword);
        if (encryptionPassword.equals(databasePassword)) {
            return true;
        } else {
            return false;
        }

    }
}
