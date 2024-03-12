package com.example.crud.Dto.Post;

import lombok.Data;

@Data
public class UpdatePostDto {
    Long id;
    String title;
    String context;
}
