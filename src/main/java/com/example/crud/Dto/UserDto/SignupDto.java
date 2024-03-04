package com.example.crud.Dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupDto {
    String email;
    String userName;
    String password;
    String nickname;
}
