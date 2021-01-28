package com.zzz.pontos.java.link;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SingleLink
 * @Description 单链表
 * @Author 25703
 * @Date 2020/9/9 16:32
 * @Version 1.0.0
 **/
public class SingleLink<T> {

    LinkNode<T> head;

    private Integer size;

    /**
     * 头插法
     *
     * @param t
     */
    public void addHead(T t) {
        if (head == null) {
            head = new LinkNode<>(t, null);
            size = 1;
        } else {
            LinkNode curNode = head;
            LinkNode newNode = new LinkNode(t, null);
            head = newNode;
            head.setNext(curNode);
            size++;
        }
    }

    /**
     * 尾插法
     *
     * @param t
     */
    public void addTail(T t) {
        if (head == null) {
            head = new LinkNode<>(t, null);
            size = 1;
            return;
        }
        LinkNode curNode = head;
        while (curNode.getNext() != null) {
            curNode = curNode.getNext();
        }
        LinkNode newNode = new LinkNode(t, null);
        curNode.setNext(newNode);
        size++;
    }

    /**
     * 数据打印
     */
    public void print() {
        LinkNode curNode = head;
        while (curNode != null) {
            T t = (T) curNode.getData();
            System.out.print(t + "\t");
            curNode = curNode.getNext();
        }
    }

    public T delHead() {
        LinkNode delNode = null;
        if (head == null) {
            return null;
        } else {
            delNode = head;
            LinkNode nextNode = head.getNext();
            head = nextNode;
        }
        T data = (T) delNode.getData();
        delNode = null;
        return data;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class LinkNode<T> {
    private T data;
    private LinkNode next;
}
