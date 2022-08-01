package com.pontons.netty.demo.notice;

import com.pontons.netty.demo.bean.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className MyNoticeHandler
 * @description TODO
 * @date 2022/8/1
 */
@Service("MyNoticeHandler")
public class MyNoticeHandler implements NoticeHandler {
    @Override
    public NoticeResponse produce(NoticeRequest request) {
        List<NoticeBody> noticeBodyList = new ArrayList<>();
        Person person = Person.builder().age("24").name("zhangsan").build();
        NoticeBody body = NoticeBody.builder().opid(request.getToken())
                .noticeBizType("1111")
                .noticeContent(person)
                .noticeId("ssasasa")
                .pushWay(1)
                .build();
        noticeBodyList.add(body);
        NoticeResponse response = NoticeResponse.builder().notices(noticeBodyList).build();
        return response;
    }

    @Override
    public void consumer(NoticeRequest request) {

    }

    @Override
    public NoticeResponse push() {
        return null;
    }
}
