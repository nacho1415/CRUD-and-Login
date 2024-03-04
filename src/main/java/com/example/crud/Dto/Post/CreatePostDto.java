package com.example.crud.Dto.Post;

import com.example.crud.Domain.User;
import lombok.Getter;

@Getter
public class CreatePostDto {
        private String title;
        private String context;
        private User user;
}
