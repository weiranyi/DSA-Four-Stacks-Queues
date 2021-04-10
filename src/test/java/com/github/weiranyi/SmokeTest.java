package com.github.weiranyi;

import com.github.weiranyi.queues.ArrayQueue;
import com.github.weiranyi.stacks.ArrayStack;
import com.github.weiranyi.stacks.Solution;
import org.junit.jupiter.api.Test;

public class SmokeTest {
    @Test
    public void test() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([)]"));
        // 队列---------
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
