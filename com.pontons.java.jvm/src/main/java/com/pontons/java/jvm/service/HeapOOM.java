package com.pontons.java.jvm.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className HeapOOM
 * @description TODO
 * @date 2022/1/27
 */
public class HeapOOM {
    static  class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
