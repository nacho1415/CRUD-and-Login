package com.example.crud.Domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String context;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    public void setUser (User user) {
        this.user = user;
    }
    public void setTitle (String title) {
        this.title = title;
    }

    public void setContext (String context) {
        this.context = context;
    }

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();
}
