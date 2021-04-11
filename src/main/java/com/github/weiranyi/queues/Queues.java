package com.github.weiranyi.queues;

/**
 * @author: https://github.com/weiranyi
 * @description
 * @date: 2021/4/10 10:10 下午
 * @Version 1.0
 */
public interface Queues<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
