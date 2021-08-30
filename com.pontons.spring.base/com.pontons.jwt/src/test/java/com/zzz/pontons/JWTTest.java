package com.zzz.pontons;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Header;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JWTTest
 * @Description TODO
 * @Author zhengzz
 * Date 2021/2/23
 * @Version 1.0.0
 */
public class JWTTest {
    @Test
    public void testJwt() {
        Algorithm algorithm = Algorithm.HMAC256("testjwt");
        Map<String, Object> map = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());//设置起时间
        cal.add(Calendar.YEAR, 1);//增加一年
        map.put("typ", "JWT");
        map.put("alg", algorithm.getName());
        String token = JWT.create().withHeader(map)//添加头部
                .withClaim("userid", "001")//添加payload
                .withClaim("username", "zhangsan")
                .withClaim("email", "12345")
                .withExpiresAt(cal.getTime())//设置过期时间
                .sign(algorithm);//设置签名 密钥
        System.out.println(token);

        // 验证 token
        //创建验证对象,这里使用的加密算法和密钥必须与生成TOKEN时的相同否则无法验证
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("testjwt")).build();
        //验证JWT
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        //获取JWT中的数据,注意数据类型一定要与添加进去的数据类型一致,否则取不到数据
        System.out.println(decodedJWT.getClaim("userid").asString());
        System.out.println(decodedJWT.getClaim("username").asString());
        System.out.println(decodedJWT.getClaim("email").asString());
        System.out.println(decodedJWT.getExpiresAt());
    }
}
