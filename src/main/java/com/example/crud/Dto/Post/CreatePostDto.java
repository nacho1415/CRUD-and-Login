package com.example.crud.Dto.Post;

import com.example.crud.Domain.User;
import lombok.Data;
import lombok.Getter;

@Data
public class CreatePostDto {
        private String title;
        private String context;
}
