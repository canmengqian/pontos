package com.pontons.netty.demo.notice;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className NoticeManager
 * @description TODO
 * @date 2022/7/29
 */
@Component
@Slf4j
public class NoticeManager {

    @Resource
    @Qualifier("MyNoticeHandler")
    private NoticeHandler myNoticeHandler;

    public NoticeResponse handle(NoticeRequest request) {
        return myNoticeHandler.produce(request);
    }


    public NoticeResponse push(NoticeRequest request) {
        return null;
    }

    public String jsonStr(NoticeResponse response) {
        if (Objects.nonNull(response) && Objects.nonNull(response.getNotices())) {
            if (CollUtil.isNotEmpty(response.getNotices())) {
                return JSONUtil.toJsonStr(response);
            }
        }
        return null;
    }


}
