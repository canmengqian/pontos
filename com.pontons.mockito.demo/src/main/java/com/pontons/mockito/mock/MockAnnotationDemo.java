package com.pontons.mockito.mock;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className MockAnnotationDemo
 * @description 注解方式模拟
 * @date 2021/8/31
 */
@RunWith(MockitoJUnitRunner.class)
public class MockAnnotationDemo {
    @Mock
    private ArrayList list;
}
