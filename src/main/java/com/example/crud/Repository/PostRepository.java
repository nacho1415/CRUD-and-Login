package com.example.crud.Repository;

import com.example.crud.Domain.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

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