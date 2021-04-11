package com.github.weiranyi;

import com.github.weiranyi.queues.ArrayQueue;
import com.github.weiranyi.queues.LoopQueue;
import com.github.weiranyi.stacks.ArrayStack;
import com.github.weiranyi.stacks.Solution;
import org.junit.jupiter.api.Test;

public class SmokeTest {
    @Test
    public void test() {
        System.out.println("---------栈---------");
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([)]"));
        // 数组队列---------
        System.out.println("---------数组队列---------");
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
        // 循环队列
        System.out.println("---------循环队列---------");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            // 存放
            loopQueue.enqueue(i);
            System.out.println(loopQueue);

            // 每隔3个出一次
            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }

    }
}
