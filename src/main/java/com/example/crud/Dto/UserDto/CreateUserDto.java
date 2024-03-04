package com.example.crud.Dto.UserDto;

import com.example.crud.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserDto {

    String username;
    String password;
    String nickname;
}

