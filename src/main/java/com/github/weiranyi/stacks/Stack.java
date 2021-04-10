package com.github.weiranyi.stacks;

/**
 * @author: https://github.com/weiranyi
 * @description
 * @date: 2021/4/10 8:17 下午
 * @Version 1.0
 */
public interface Stack<E> {
    int getSize(); // 返回int

    boolean isEmpty();

    void push(E e); //添加元素

    E pop(); // 取出元素

    E peek(); // 看栈顶元素
}
