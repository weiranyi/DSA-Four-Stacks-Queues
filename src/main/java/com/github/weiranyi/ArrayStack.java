package com.github.weiranyi;

import com.github.weiranyi.entity.Array;

/**
 * @author: https://github.com/weiranyi
 * @description
 * @date: 2021/4/10 8:19 下午
 * @Version 1.0
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    // 指定内存空间容量
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
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

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    // 查看容量
    public int getCapacity(){
        return array.getCapacity();
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("']'top");
        return res.toString();
    }
}
