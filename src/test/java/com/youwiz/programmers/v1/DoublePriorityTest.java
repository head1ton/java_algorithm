package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

@SpringBootTest
public class DoublePriorityTest {

    @Test
    public void doublePriority() {
//        String[] operations = {"I 16", "D 1"};
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};
        int[] answer = new int[2];
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");
            switch (s[0]) {
                case "I":
                    maxPQ.add(Integer.parseInt(s[1]));
                    minPQ.add(Integer.parseInt(s[1]));
                    break;
                case "D":
                    if (minPQ.isEmpty()) {
                        break;
                    }
                    if (s[1].equals("1")) {
                        int max = maxPQ.poll();
                        minPQ.remove(max);
                    } else {
                        int min = minPQ.poll();
                        maxPQ.remove(min);
                    }
                    break;
            }
        }
        answer[0] = maxPQ.isEmpty() ? 0 : maxPQ.poll();
        answer[1] = minPQ.isEmpty() ? 0 : minPQ.poll();

        System.out.println("max = " + answer[0] + ", min = " + answer[1]);
    }

    @Test
    public void doublePriority1() {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = new int[2];


        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
