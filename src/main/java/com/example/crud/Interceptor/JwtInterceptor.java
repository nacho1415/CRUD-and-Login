//package com.example.crud.Interceptor;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//public class JwtInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        // 요청 처리 전에 실행될 로직을 작성합니다.
//        return true; // true를 반환하면 요청이 계속 진행됩니다. false를 반환하면 요청이 중단됩니다.
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//        // 요청 처리 후, 뷰가 렌더링되기 전에 실행될 로직을 작성합니다.
//        System.out.println("Post-handle logic executed");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        // 요청 처리가 완료된 후 실행될 로직을 작성합니다.
//        System.out.println("After-completion logic executed");
//    }
//
//}