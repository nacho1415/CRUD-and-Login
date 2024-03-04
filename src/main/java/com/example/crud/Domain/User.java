package com.example.crud.Domain;

import com.example.crud.Dto.UserDto.SignupDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Entity
@Table(name = "users")
public class User {

    private static final int MIN_USERNAME_LENGTH = 3;
    private static final int MAX_USERNAME_LENGTH = 20;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 20;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List <Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List <Like> likes = new ArrayList<>();

    public void setUsername(String username) {
        this.userName = username;
    }

    public void setNickname(String nickname) { this.nickname = nickname; }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = password;
    }

    public void ValidateSignupDto(SignupDto signupDto) {
        if (signupDto.getUserName() == null ||
                signupDto.getUserName().length() < MIN_USERNAME_LENGTH ||
                signupDto.getUserName().length() > MAX_USERNAME_LENGTH) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (signupDto.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        if (!Pattern.matches(EMAIL_PATTERN, signupDto.getEmail())) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (signupDto.getPassword() == null ||
                signupDto.getPassword().length() < MIN_PASSWORD_LENGTH ||
                signupDto.getPassword().length() > MAX_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Invalid password");
        }
    }

}
