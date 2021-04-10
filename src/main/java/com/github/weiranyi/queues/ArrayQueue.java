package com.github.weiranyi.queues;

import com.github.weiranyi.entity.Array;

/**
 * @author: https://github.com/weiranyi
 * @description 这是一个数组队列类
 * @date: 2021/4/10 10:15 下午
 * @Version 1.0
 */
public class ArrayQueue<E> implements Queues<E> {
    private Array<E> array;

    // 在内存开辟的内存空间的数量
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    // 添加一个元素,想这个末尾添加一个元素
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    // 从这个队列中拿出一个元素
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("head [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


}
