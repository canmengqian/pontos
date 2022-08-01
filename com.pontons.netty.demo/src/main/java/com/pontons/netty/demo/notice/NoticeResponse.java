package com.pontons.netty.demo.notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className NoticeResponse
 * @description TODO
 * @date 2022/7/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class NoticeResponse {
    List<NoticeBody> notices;
}
