package com.example.crud.Post;

import com.example.crud.Domain.Post;
import com.example.crud.Domain.User;
import com.example.crud.Repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void 게시글전체조회 () {
        List<Post> posts = postRepository.findAll();
    }
}
