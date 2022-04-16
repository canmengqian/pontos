package com.pontons.spring.source.demo.context.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className DigesterUtilTest
 * @description TODO
 * @date 2022/1/17
 */
@Slf4j
public class DigesterUtilTest {
    @Test
    public void digisterUtil(){
        DigestUtils.md5Digest(new byte[10]);
    }
}
