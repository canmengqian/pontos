package com.pontons.netty.demo.notice;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className NoticeParam
 * @description TODO
 * @date 2022/7/29
 */
public class NoticeParam {
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
