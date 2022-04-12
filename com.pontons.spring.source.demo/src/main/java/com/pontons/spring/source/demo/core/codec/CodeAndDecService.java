package com.pontons.spring.source.demo.core.codec;

import org.springframework.core.codec.CharSequenceEncoder;
import org.springframework.core.codec.Encoder;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className CodeAndDecService
 * @description TODO
 * @date 2022/2/2
 */
public class CodeAndDecService {
    public void testEncoder() {
        Encoder encoder = CharSequenceEncoder.textPlainOnly();

    }
}
