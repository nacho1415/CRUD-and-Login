package com.example.crud.Domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "likes")
public class Like {

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
