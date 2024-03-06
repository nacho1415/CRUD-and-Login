package com.example.crud.Service;

import com.example.crud.Domain.User;
import com.example.crud.Dto.UserDto.LoginDto;
import com.example.crud.Dto.UserDto.SignupDto;
import com.example.crud.Exception.User.DuplicateNicknameException;
import com.example.crud.JWT.JwtTokenProvider;
import com.example.crud.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class UserService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 20;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User signup (SignupDto signupDto) throws DuplicateNicknameException {
        User user = new User();
        String inputNickname = signupDto.getNickname();

        //중복 체크
        if (userRepository.DuplicateNicknameCheck(inputNickname)) {
            throw new DuplicateNicknameException("Duplicate nickname");
        }
        //validate 체크
        user.ValidateSignupDto(signupDto);

        String encryptionPassword = passwordEncoder.encode(signupDto.getPassword());
        user.setPassword(encryptionPassword);
        user.setEmail(signupDto.getEmail());
        user.setNickname(signupDto.getNickname());

        userRepository.save(user);
        return user;
    }

    public void validateLoginDto (LoginDto loginDto) {
        if (loginDto.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        if (!Pattern.matches(EMAIL_PATTERN, loginDto.getEmail())) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (loginDto.getPassword() == null ||
                loginDto.getPassword().length() < MIN_PASSWORD_LENGTH ||
                loginDto.getPassword().length() > MAX_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Invalid password");
        }
    }
    public Map<String, Object> login (LoginDto loginDto) {
        Map<String, Object> response = new HashMap<>();

        try {
            validateLoginDto(loginDto);
            User user = userRepository.findByEmail(loginDto.getEmail());
            if (user == null) {
                throw new IllegalArgumentException("cannot find email");
            }
            Long userId = user.getId();
            if (userRepository.isSamePassword(user.getPassword(), loginDto.getPassword())) {
                throw new IllegalArgumentException("password is wrong");
            }
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
            String token = jwtTokenProvider.generateToken(user.getNickname());

            response.put("token", token);
            response.put("user", user);
            return response;
        } catch (IllegalArgumentException e) {
            return response;
        }
    }
}
