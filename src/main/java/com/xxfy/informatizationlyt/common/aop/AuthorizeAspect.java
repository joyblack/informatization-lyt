package com.xxfy.informatizationlyt.common.aop;

import com.xxfy.informatizationlyt.common.exception.JoyException;
import com.xxfy.informatizationlyt.config.JwtParamConfig;
import com.xxfy.informatizationlyt.utils.jwt.JwtUtil;
import com.xxfy.informatizationlyt.utils.jwt.Token;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * aop登陆拦截前台
 *
 * @author 13562
 */
@Aspect
@Component
public class AuthorizeAspect {

    @Autowired
    private JwtParamConfig jwtParamConfig;

    @Pointcut("execution(public * com.xxfy.informatizationlyt.*.web.*.*(..))"
            + "&&!execution(public * com.xxfy.informatizationlyt.user.web.LoginController.*(..))"
            + "&&!execution(public * com.xxfy.informatizationlyt.user.web.UserController.*(..))"
            + "&&!execution(public * com.xxfy.informatizationlyt.heart.web.*.*(..))"

           )
    public void auth() {
    }

    @Before("auth()")
    public void doAuth() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        final Object authHeader = request.getHeader(Token.AUTHORIZATION.getName());
        if (authHeader == null) {
            throw new JoyException("用户尚未登陆");
        }
        final Claims claims = JwtUtil.parseJWT(authHeader.toString(), jwtParamConfig.getBase64Security());
        if (claims == null) {
            throw new JoyException("用户尚未登陆");
        }
        request.setAttribute(Token.CLAIMS.getName(), claims);
        response.setHeader(Token.AUTHORIZATION.getName(), JwtUtil.createJWT(claims, jwtParamConfig));
    }
}
