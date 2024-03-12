package com.example.crud.Controller;

import com.example.crud.Dto.UserDto.LoginDto;
import com.example.crud.Dto.UserDto.SignupDto;
import com.example.crud.Exception.User.DuplicateNicknameException;
import com.example.crud.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signUp (@RequestBody SignupDto signupDto) {
        try {
            userService.signup(signupDto);
            return ResponseEntity.ok("success");
        } catch (DuplicateNicknameException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("닉네임 중복");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login (@RequestBody LoginDto loginDto) {
        try {
            Map<String, Object> response = userService.login(loginDto);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
