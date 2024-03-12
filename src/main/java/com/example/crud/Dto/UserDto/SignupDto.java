package com.example.crud.Dto.UserDto;

import lombok.*;

@Data
@NoArgsConstructor
public class SignupDto {
    private String email;
    private String password;
    private String nickname;

    // 추가적으로 필요한 생성자나 메서드 등이 있다면 여기에 작성합니다.
}
