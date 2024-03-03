package com.example.crud.Service;

import com.example.crud.Domain.Post;
import com.example.crud.Domain.User;
import com.example.crud.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post createPost (String title, String context,User user) {
        Post post = new Post();
        post.setTitle(title);
        post.setContext(context);
        post.setUser(user);
        postRepository.save(post);
        return post;
    }

    public User signup () {

    }
}
