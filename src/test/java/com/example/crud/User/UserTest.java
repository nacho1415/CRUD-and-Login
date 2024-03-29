package com.example.crud.User;

import com.example.crud.Domain.User;
import com.example.crud.Dto.UserDto.CreateUserDto;
import com.example.crud.Dto.UserDto.LoginDto;
import com.example.crud.Dto.UserDto.SignupDto;
import com.example.crud.Exception.User.DuplicateNicknameException;
import com.example.crud.JWT.JwtTokenProvider;
import com.example.crud.Repository.UserRepository;
import com.example.crud.Service.UserService;
import org.apache.juli.logging.Log;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @Test
    public void 유저전체조회 () {
        int users = userRepository.findAll().size();
        Assertions.assertThat(users).isEqualTo(2);
    }

    @Test
    public void 회원가입 () throws DuplicateNicknameException {
        SignupDto signupDto = new SignupDto("eqwe312@naver.com", "lqwecql123123", "minseo1241412");
        userService.signup(signupDto);
    }

    @Test
    public void 로그인 () {
        LoginDto loginDto = new LoginDto("eqwe312@naver.com", "lqwecql123123");
        userService.login(loginDto);
    }
}
