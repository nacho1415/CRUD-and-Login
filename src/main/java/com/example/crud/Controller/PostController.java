package com.example.crud.Controller;

import com.example.crud.Domain.Post;
import com.example.crud.Domain.User;
import com.example.crud.Dto.Post.CreatePostDto;
import com.example.crud.Dto.Post.UpdatePostDto;
import com.example.crud.JWT.JwtTokenProvider;
import com.example.crud.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    PostService postService;

    @PostMapping("/createPost")
    public ResponseEntity<Object> createPost (@RequestHeader("Authorization") String token, @RequestBody CreatePostDto createPostDto) throws Exception {
        try {
            User user = jwtTokenProvider.validateToken(token);
            Post post = postService.createPost(user, createPostDto);
            return ResponseEntity.ok(post);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Signup failed: " + ex.getMessage());
        }
    }

    @PostMapping("/updatePost")
    public ResponseEntity<Object> updatePost (@RequestHeader("Authorization") String token, @RequestBody UpdatePostDto updatePostDto) throws Exception {
        try {
            User user = jwtTokenProvider.validateToken(token);
            postService.updatePost(user, updatePostDto);
            return ResponseEntity.ok("success");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Signup failed: " + ex.getMessage());
        }
    }

}
