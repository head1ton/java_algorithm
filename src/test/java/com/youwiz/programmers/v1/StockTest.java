package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StockTest {

    @Test
    public void stock() {
        int[] prices = {1, 2, 3, 2, 3};
        int len = prices.length;            // 가격의 길이
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        System.out.println("answer = " + answer);
    }

    @Test
    public void stock1() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = {};

        System.out.println("answer = " + answer);
    }
}
