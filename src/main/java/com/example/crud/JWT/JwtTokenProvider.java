package com.example.crud.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    // 임의로 선택한 시크릿 키
    private static final String SECRET_KEY = "secretkey";

    // 토큰의 만료 시간 (1시간)
    private static final long EXPIRATION_TIME = 3600000;

    // JWT 토큰 생성
    public static String generateToken(String nickname) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(nickname)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    // JWT 토큰에서 username 추출
    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // JWT 토큰의 유효성 검사
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // 사용자 이름으로 토큰 생성
        String token = generateToken("user123");

        // 생성된 토큰 출력
        System.out.println("Generated Token: " + token);

        // 토큰에서 사용자 이름 추출 및 출력
        String username = getUsernameFromToken(token);
        System.out.println("Username from Token: " + username);

        // 유효한 토큰 검증
        boolean isValid = validateToken(token);
        System.out.println("Token is valid: " + isValid);
    }
}