package com.pontons.netty.demo.notice;

import org.springframework.stereotype.Service;

/**
 * @author zhengzz
 * @version 1.0.0
 * @description 公告处理器
 * @date 2022/7/29
 */
@Service
public interface NoticeHandler {
    /**
     * @return
     * @Param
     * @Param request
     * @author zhengzz
     * @description 根据请求生成响应消息
     * @date 10:52 2022/7/29
     **/
    NoticeResponse produce(NoticeRequest request);

    /**
     * @return
     * @Param
     * @Param request
     * @author zhengzz
     * @description 消费请求消息
     * @date 10:53 2022/7/29
     **/
    void consumer(NoticeRequest request);

    /**
     * @return
     * @Param
     * @author zhengzz
     * @description 消息推送
     * @date 13:19 2022/7/29
     **/
    NoticeResponse push();


}
