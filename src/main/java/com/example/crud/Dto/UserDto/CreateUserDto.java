package com.example.crud.Dto.UserDto;

import com.example.crud.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateUserDto {

    String email;
    String password;
    String nickname;
}

