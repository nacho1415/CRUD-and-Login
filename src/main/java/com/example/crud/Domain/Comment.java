package com.example.crud.Domain;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PostId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;
}
