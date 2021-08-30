package com.pontons.vavr.collection;

import io.vavr.collection.List;
import io.vavr.collection.Queue;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;


/**
 * @author zhengzz
 * @version 1.0.0
 * @className CollectionDEmo
 * @description TODO
 * @date 2021/8/27
 */
public class CollectionDemo {
    @Test
    public  void testList() {
        // 初始话并追加操作
        List<Integer> list = List.of(1,2,3).append(4);
        System.out.println(list.size());
        list.out(System.out);
        /*查找*/
        System.out.println("第一个元素:"+list.get(0));
        System.out.println("不存在的元素:"+list.getOrElse(9));
        //System.out.println("不存在的元素:"+list.getOrElseThrow(e->new NoSuchElementException()));
        System.out.println("不存在的元素:"+list.getOrNull());
        System.out.println("列表转字符串"+list.mkCharSeq("|").toString());

    }


}
