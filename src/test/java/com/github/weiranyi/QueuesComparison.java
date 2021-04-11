package com.github.weiranyi;

import com.github.weiranyi.queues.Queues;
import com.github.weiranyi.queues.ArrayQueue;
import com.github.weiranyi.queues.LoopQueue;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author: https://github.com/weiranyi
 * @description
 * @date: 2021/4/11 11:32 上午
 * @Version 1.0
 */
public class QueuesComparison {

    @Test
    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queues<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }
}
