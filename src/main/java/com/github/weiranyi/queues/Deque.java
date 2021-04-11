package com.github.weiranyi.queues;

/**
 * @author: https://github.com/weiranyi
 * @description 实现一个双端队列
 * @date: 2021/4/11 2:16 下午
 * @Version 1.0
 */
public class Deque<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public Deque(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    public Deque() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // 和基础队列实现类似
    public void addLast(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void addFront(E e) {

        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        // 我们首先需要确定添加新元素的索引位置front - 1
        // 如果 front == 0，新的位置是 data.length - 1 的位置
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size++;
    }

    // 和基础队列实现类似
    public E removeFront() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E removeLast() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        // 计算删除掉队尾元素以后，新的 tail 位置
        tail = tail == 0 ? data.length - 1 : tail - 1;
        E ret = data[tail];
        data[tail] = null;
        size--;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    // 因为是双端队列，我们也有一个 getLast 的方法，来获取队尾元素的值
    public E getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        // 因为 tail 指向的是队尾元素的下一个位置，我们需要计算一下真正队尾元素的索引
        int index = tail == 0 ? data.length - 1 : tail - 1;
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Deque: capacity :%d, size:%d", getCapacity(), getSize()));
        res.append("front[");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]tail");
        return res.toString();
    }

    public static void main(String[] args) {
        // 偶数从队尾加入；奇数从队首加入
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                deque.addLast(i);
            } else {
                deque.addFront(i);
            }
            System.out.println(deque);
        }

        // 一次从队首、队尾，出队
        System.out.println();
        for (int i = 0; !deque.isEmpty(); i++) {
            if (i % 2 == 0) {
                deque.removeFront();
            } else {
                deque.removeLast();
            }
            System.out.println(deque);
        }
    }


}

