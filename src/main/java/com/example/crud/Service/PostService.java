package com.example.crud.Service;

import com.example.crud.Domain.Post;
import com.example.crud.Domain.User;
import com.example.crud.Dto.Post.CreatePostDto;
import com.example.crud.Dto.UserDto.SignupDto;
import com.example.crud.Repository.PostRepository;
import com.example.crud.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    public Post createPost (CreatePostDto createPostDto) {
        Post post = new Post();
        post.setTitle(createPostDto.getTitle());
        post.setContext(createPostDto.getContext());
        post.setUser(createPostDto.getUser());
        postRepository.save(post);
        return post;
    }
}
