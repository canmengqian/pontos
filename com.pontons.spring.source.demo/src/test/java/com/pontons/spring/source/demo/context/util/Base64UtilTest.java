package com.pontons.spring.source.demo.context.util;


import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.Base64Utils;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className Base64UtilTest
 * @description TODO
 * @date 2022/1/17
 */
@Slf4j
public class Base64UtilTest {
    @Test
    public void testBase64Util() {
        String val = "hello world";
        byte[] urlBytes = Base64Utils.decodeFromUrlSafeString(val);

        log.info(Base64Utils.encodeToString(urlBytes));
    }
}
