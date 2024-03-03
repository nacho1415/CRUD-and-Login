package com.example.crud.Repository;

import com.example.crud.Domain.Post;
import com.example.crud.Domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.springframework.stereotype.Repository;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

@Repository
public class PostRepository {

    @PersistenceContext
    EntityManager em;

    public void save (Post post) {
        em.persist(post);
    }

    public List<Post> findAll () {
        return em.createQuery("SELECT p FROM Post p").getResultList();
    }
}
