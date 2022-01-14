package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.PriorityQueue;

@SpringBootTest
public class SpiceHeapTest {

    @Test
    public void spiceHeap() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            que.offer(scoville[i]);
        }

        while (que.size() > 1 && que.peek() < K) {
            int weakHot = que.poll();
            int secondWeakHot = que.poll();
            int mixHot = weakHot + (secondWeakHot * 2);
            que.offer(mixHot);
            answer++;
        }

        if (que.size() <= 1 && que.peek() < K)
            answer = -1;

        System.out.println("answer = " + answer);
    }
}
