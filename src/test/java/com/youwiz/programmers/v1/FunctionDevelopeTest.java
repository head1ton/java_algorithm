package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class FunctionDevelopeTest {

    @Test
    public void functionDev() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] answer;

        int[] dayOfend = new int[100];
        int day = -1;

        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        answer = Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }

    @Test
    public void functionDev1() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }
            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
