package com.example.crud.Service;

import com.example.crud.Domain.Post;
import com.example.crud.Domain.User;
import com.example.crud.Dto.Post.CreatePostDto;
import com.example.crud.Dto.Post.UpdatePostDto;
import com.example.crud.Dto.UserDto.SignupDto;
import com.example.crud.JWT.JwtTokenProvider;
import com.example.crud.Repository.PostRepository;
import com.example.crud.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Transactional
    public Post createPost (User user, CreatePostDto createPostDto) throws Exception {
        try {
            postRepository.duplicateCheck(createPostDto);
            Post post = new Post();
            post.setTitle(createPostDto.getTitle());
            post.setContext(createPostDto.getContext());
            post.setUser(user);
            postRepository.save(post);
            return post;
        } catch (Exception ex) {
            throw new Exception("게시물을 만드는 도중 오류 발생");
        }
    }

    @Transactional
    public void updateProduct (UpdatePostDto updatePostDto) throws Exception {
        try {
            System.out.println(updatePostDto + "파라미터 체크");
            // 파라미터가 모두 Null인지 검사
            postRepository.updateProductAllNullCheck(updatePostDto);

            // 업데이트 내용이 올바른 입력인지 검사
            postRepository.updateProductValidationCheck(updatePostDto);

            System.out.println(updatePostDto.getId() + "확인");

            // 업데이트 내용이 있는것들 변경
            Post post = postRepository.findProductById(updateProductDto.getId());
            productRepository.updateProductWithChanges(product, updateProductDto);

        } catch (Exception ex) {
            throw new Exception("fail reason = " + ex.getMessage());
        }
    }

}
