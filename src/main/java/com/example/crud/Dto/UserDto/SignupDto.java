package com.example.crud.Dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupDto {
    String email;
    String password;
    String nickname;
}
