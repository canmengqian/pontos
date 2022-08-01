package com.pontons.netty.demo.notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className NoticeBody
 * @description TODO
 * @date 2022/7/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class NoticeBody {
    String opid;
    /**
     * 推送方式 0:前端请求, 1:服务端推送 2:前后交互 3: 三方服务调用消息平台
     */
    int pushWay;
    /**
     * 消息ID
     */
    String noticeId;

    /**
     * 消息内容
     */
    Object noticeContent;
    /**
     * 消息业务类型
     */
    String noticeBizType;

    /**
     * 0:服务端回报 2:前端回报 3:前端请求
     */
    int noticeType;
}
