package com.ynu.makeup_you.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ynu.makeup_you.annotation.PassToken;
import com.ynu.makeup_you.annotation.UserLoginToken;
import com.ynu.makeup_you.entity.AdminUser;
import com.ynu.makeup_you.entity.User;
import com.ynu.makeup_you.service.AdminUserService;
import com.ynu.makeup_you.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created on 2019/6/8 0008
 * BY hujianlong
 * 拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserService adminUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从http请求头部中获取token
        String token = request.getHeader("token");

        // 如果这里不是映射到方法就直接通过
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();

        // 检查有没有passToken注释，有的话就跳过验证
        if (method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()){
                return true;
            }
        }

        // 检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()){
                // 执行认证
                if (token == null){
                    throw new RuntimeException("没有token，请重新登录!");
                }
                // 获取token中的userID（User）/name（adminUser）
                String id;
                try{
                    id = JWT.decode(token).getAudience().get(0);
                } catch(JWTDecodeException j){
                    throw new RuntimeException("401");
                }

                User user = userService.getUserByID(id);
                AdminUser au = adminUserService.findAdminByName(id);

                if (user == null){
                    if (au == null){
                        throw new RuntimeException("用户不存在，请重新登录!");
                    }else{
                        // 验证token
                        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(au.getPassword())).build();
                        try{
                            jwtVerifier.verify(token);
                        } catch (JWTVerificationException je){
                            throw new RuntimeException("401");
                        }
                        return true;
                    }
                }else{
                    // 验证token
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                    try{
                        jwtVerifier.verify(token);
                    } catch (JWTVerificationException je){
                        throw new RuntimeException("401");
                    }
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
