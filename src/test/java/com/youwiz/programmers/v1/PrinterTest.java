package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

@SpringBootTest
public class PrinterTest {

    @Test
    public void printer() {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<>();
        for (int i : priorities) {
            que.offer(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while (!que.isEmpty()) {
            Integer i = que.poll();
            if (i == priorities[size - answer]) {
                answer++;
                l--;
                if (l < 0)
                    break;
            } else {
                que.offer(i);
                l--;
                if (l < 0)
                    l = que.size() - 1;
            }
        }

        System.out.println("answer = " + answer);
    }

    @Test
    public void printer1() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<>();
        for (int i : priorities) {
            que.offer(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while (!que.isEmpty()) {
            int i = que.poll();
            if (i == priorities[size - answer]) {
                answer++;
                l--;
                if (l < 0) {
                    break;
                }
            } else {
                que.offer(i);
                l--;
                if (l < 0) {
                    l = que.size() - 1;
                }
            }
        }
        System.out.println("answer = " + answer);
    }

    @Test
    public void printer2() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<>();
        for (int i : priorities) {
            que.offer(i);   // 1, 1, 9, 1, 1, 1
        }

        Arrays.sort(priorities);    // 1, 1, 1, 1, 1, 9
        int size = priorities.length - 1;

        while (!que.isEmpty()) {
            int i = que.poll();
            if (i == priorities[size - answer]) {
                answer++;
                l--;
                if (l < 0) {
                    break;
                }
            } else {
                que.offer(i);
                l--;
                if (l < 0) {
                    l = que.size() - 1;
                }
            }
        }

        System.out.println("answer = " + answer);
    }
}
