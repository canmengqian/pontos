package com.pontons.authentic.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pontons.authentic.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className JwtTest
 * @description TODO
 * @date 2021/6/17
 */
@Slf4j
public class JwtTest {
    @Test
    public void testJwt() throws InterruptedException {
        User user = User.builder().name("张三").age(24).pwd("123456").build();
        String token= JWT.create().withAudience("audience") //听众
                .withIssuedAt(new Date()) // 发布时间
                .withSubject("subject")
                .withExpiresAt(new Date())// 过期时间
                .withJWTId("jtiid")
                .withKeyId("111")
                .sign(Algorithm.HMAC256(user.getPwd())) // 加签处理
                ;
        log.info(token);
        //  解签
        DecodedJWT decodedJWT = JWT.decode(token);
       log.info("head {} ",decodedJWT.getHeader());
        log.info("payload {}",decodedJWT.getPayload());
        log.info("subject {}",decodedJWT.getSubject());
        log.info("过期 {}",decodedJWT.getExpiresAt().toString());
        log.info("签名 {}",decodedJWT.getSignature());
        log.info("算法 {}",decodedJWT.getAlgorithm());
        log.info("id {}",decodedJWT.getId());
        log.info("keyId {}",decodedJWT.getKeyId());
        Thread.sleep(10000);
        // 验证token
        try {
            JWT.require(Algorithm.HMAC256(user.getPwd())).build().verify(token);
        }catch (TokenExpiredException e) {
            Assert.isInstanceOf(TokenExpiredException.class,e,"token过期");
        }

    }


}
