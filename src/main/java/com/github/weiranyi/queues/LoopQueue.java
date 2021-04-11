package com.github.weiranyi.queues;

/**
 * @author: https://github.com/weiranyi
 * @description 循环队列
 * @date: 2021/4/11 10:28 上午
 * @Version 1.0
 */
public class LoopQueue<E> implements Queues<E> {
    private E[] data;
    private int head, tail;
    private int size;

    // 用户期望开辟的空间大小是capacity，但为了实现循环队列需要在原来的基础上+1
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        head = 0; // 将head指针指向开始位置
        tail = 0; // 将tail指针指向尾部位置
        size = 0; // size可见容量
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        // 这个数组的长度实际上需要减1（在开辟空间时增加的部分）
        return data.length - 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == head) {
            resize(getCapacity() * 2);
        }
        data[tail] = e; //在队尾增加元素
        tail = (tail + 1) % data.length; //维护队尾指针
        size++; // 数量+1
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("操作非法，队列已为空，无法出队");
        }
        E ret = data[head];
        data[head] = null;
        head = (head + 1) % data.length; // 维护下head
        size--;
        if (size == getCapacity() / 4) {
            // 防止空间浪费，进行缩容
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("操作非法，队列已为空，无法出队");
        }
        return data[head];
    }

    private void resize(int newCapacity) {
        E[] newBase = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newBase[i] = data[(i + head) % data.length];
        }
        data = newBase;
        head = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d", size, getCapacity()));
        res.append("head [");
        for (int i = head; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
