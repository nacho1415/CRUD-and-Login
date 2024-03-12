//package com.example.crud.Exception.ExceptionAspect;
//
//import com.example.crud.Exception.User.DuplicateNicknameException;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class ExceptionAspect {
//
//    @AfterThrowing(pointcut = "execution(* com.example.service.UserService.signup(..))", throwing = "ex")
//    public void handleException(Exception ex) {
//        if (ex instanceof DuplicateNicknameException) {
//            // 중복 닉네임 예외 처리 로직
//            // 예: 로그 출력 등
//            System.out.println("\"Duplicate nickname");
//        } else {
//            // 다른 예외 처리 로직
//            // 예: 로그 출력 등
//            System.out.println("서버 에러 발생");
//        }
//    }
//}