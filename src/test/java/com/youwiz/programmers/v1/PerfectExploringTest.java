package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class PerfectExploringTest {

    @Test
    public void perfectExploring() {
//        int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1, 3, 2, 4, 2};
        int[] player1 = {1, 2, 3, 4, 5};
        int[] player2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] player3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == player1[i % player1.length]) {
                score[0]++;
            }
            if (answers[i] == player2[i % player2.length]) {
                score[1]++;
            }
            if (answers[i] == player3[i % player3.length]) {
                score[2]++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max_index = 0;
        for (int i = 0; i < 3; i++) {
            if (score[max_index] < score[i]) {
                max_index = i;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (score[max_index] == score[i]) {
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i) + 1;
        }
        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }

    @Test
    public void perfectExploring1() {
        int[] answers = {1, 3, 2, 4, 2};
        int[] answer = {};
        int[] player1 = {1, 2, 3, 4, 5};
        int[] player2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] player3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }

    @Test
    public void perfectExploring2() {
        int[] answers = {1, 3, 2, 4, 2};
        int[] answer = {};
        int[] player1 = {1, 2, 3, 4, 5};
        int[] player2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] player3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
