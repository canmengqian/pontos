package com.pontons.mockito.mock;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.internal.InOrderImpl;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.verification.VerificationMode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * @author zhengzz
 * @version 1.0.0
 * @className MockDemo
 * @description TODO
 * @date 2021/8/31
 */
public class MockDemo {
    @Test
    public void testMockList() {
        List mockedList = Mockito.mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        Mockito.verify(mockedList).add("one");
        Mockito.verify(mockedList).clear();
    }

    @Test
    public void testStubList() {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = Mockito.mock(LinkedList.class);

// stubbing appears before the actual execution
        Mockito.when(mockedList.get(0)).thenReturn("first");
// the following prints "first"
        System.out.println(mockedList.get(0));

// the following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));
    }

    /*
     * @author zhengzz
     * @description 参数匹配器
     * @date 15:12 2021/8/31
     * @param []
     * @return void
     **/
    @Test
    public void testArgu() {
        LinkedList mockedList = Mockito.mock(LinkedList.class);
        /*任意参数*/
        Mockito.when(mockedList.get(ArgumentMatchers.anyInt())).thenReturn("element");
        /*异常抛出*/
        Mockito.when(mockedList.get(ArgumentMatchers.eq(1))).thenThrow(NoSuchElementException.class);
        /*Answer*/
        Mockito.when(mockedList.get(ArgumentMatchers.eq(2))).then(
                (Answer) invocation -> {
                    Object[] args = invocation.getArguments();
                    /*参数值*/
                    Arrays.stream(args).forEach(System.out::println);
                    Object mock = invocation.getMock();
                    System.out.println("mock class:"+ mock.getClass().toString());
                    return "called with arguments: " + Arrays.toString(args);
                });
        mockedList.get(2);
        /*打印"element"*/
        System.out.println(mockedList.get(999));

        Mockito.verify(mockedList).get(ArgumentMatchers.anyInt());
        /*抛出异常*/
        mockedList.get(1);
        /*TODO 参数捕捉器*/
        ArgumentCaptor captor = ArgumentCaptor.forClass(Integer.class);
    }

    /*
     * @author zhengzz
     * @description 次数调用
     * @date 15:48 2021/8/31
     * @param []
     * @return void
     **/
    @Test
    public void testTimes() {
        LinkedList mockedList = Mockito.mock(LinkedList.class);
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        /*succed 验证once调用1次*/
        Mockito.verify(mockedList,Mockito.times(1)).add("once");
        /*succed 从未add*/
        Mockito.verify(mockedList,Mockito.never()).add("never");
        /*succed至少一次*/
        Mockito.verify(mockedList,Mockito.atLeastOnce()).add("twice");
        /*succed至多一次*/
        Mockito.verify(mockedList,Mockito.atMostOnce()).add("once");
        /*succed至多N次*/
        Mockito.verify(mockedList,Mockito.atMost(3)).add("three times");
        /*succed至少N次*/
        Mockito.verify(mockedList,Mockito.atLeast(1)).add("twice");
        /*fail 验证once调用两次*/
        Mockito.verify(mockedList,Mockito.times(2)).add("once");
    }

    /*
     * @author zhengzz
     * @description 按顺序执行
     * @date 16:04 2021/8/31
     * @param []
     * @return void
     **/
    @Test
    public void testOrder() {
        List singleMock = Mockito.mock(List.class);
        singleMock.add("was added first");
        singleMock.add("was added second");
        InOrder inOrder = Mockito.inOrder(singleMock);
        /*succed 有序执行*/
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");
        /*fail 有序执行*/
        /*inOrder.verify(singleMock).add("was added second");
        inOrder.verify(singleMock).add("was added first");*/

        /*多对象顺序调用*/
        List firstMock = Mockito.mock(List.class);
        List secondMock = Mockito.mock(List.class);
        firstMock.add("was called first");
        secondMock.add("was called second");
         inOrder = Mockito.inOrder(firstMock, secondMock);
        /*succed 有序执行*/
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");
    }

}
