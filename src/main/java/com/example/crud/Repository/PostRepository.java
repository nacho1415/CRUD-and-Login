package com.example.crud.Repository;

import com.example.crud.Domain.Post;
import com.example.crud.Domain.User;
import com.example.crud.Dto.Post.CreatePostDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {

    @PersistenceContext
    EntityManager em;

    public void duplicateCheck (CreatePostDto createPostDto) {
        Long EmailDuplicateCount = em.createQuery("SELECT COUNT(p) FROM Post p WHERE p.title = :title", Long.class)
                .setParameter("title", createPostDto.getTitle())
                .getSingleResult();
        if (EmailDuplicateCount > 0) {
            throw new IllegalArgumentException("title is duplicated");
        }
    }

    public void save (Post post) {
        em.persist(post);
    }

    public List<Post> findAll () {
        return em.createQuery("SELECT p FROM Post p").getResultList();
    }
}
