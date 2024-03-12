package com.example.crud.JWT;

import com.example.crud.Domain.User;
import com.example.crud.Repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    JwtParser parser;

    @Autowired
    UserRepository userRepository;

    // 토큰의 만료 시간 (1시간)
    private static final long EXPIRATION_TIME = 360000000;

    @Value("${spring.jwt.secret}")
    private String jwtSecret;


    public Key getJwtSecret() {
        // 문자열을 바이트 배열로 변환하여 Key 형식으로 반환
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // JWT 토큰 생성
    public String generateToken(String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getJwtSecret())
                .compact();
    }

    // JWT 토큰의 유효성 검사
    public User validateToken(String token) throws Exception {
        try {
            token = token.replaceAll("^\"|\"$", "");
            jwtSecret = jwtSecret.replaceAll("^\"|\"$", "");
            System.out.println(token + "확인1111111");
            System.out.println(jwtSecret + "확인222222");
            this.parser = Jwts.parserBuilder().setSigningKey(jwtSecret.getBytes()).build();
            Claims claims = parser.parseClaimsJws(token).getBody();
            String email = claims.getSubject(); // 토큰에서 이메일 추출
            System.out.println();
            User user = userRepository.findByEmail(email);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("JWT 인증에 실패하셨습니다");
        }
    }
}