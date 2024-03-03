package com.example.crud.seed;

import com.example.crud.Domain.User;
import com.example.crud.Repository.PostRepository;
import com.example.crud.Repository.UserRepository;
import com.example.crud.Service.PostService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class seedPost {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @Autowired
    UserRepository userRepository;
}