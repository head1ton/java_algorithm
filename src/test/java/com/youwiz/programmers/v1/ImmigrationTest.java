package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ImmigrationTest {

    @Test
    public void immigration0() {
        int n = 6;
        int[] times = {7, 10};
        int answer = 0;

        long max = 0;
        for (int time : times) {
            if (max < time) max = time;
        }

        long start = 1, end = max * n;

        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;

            for (int time : times) {
                total += (mid / time);
            }

            if (total >= n) {
                end = mid - 1;
                answer = (int) mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("answer = " + answer);
    }

    @Test
    public void immgration1() {
        int n = 6;
        int[] times = {7, 10};
        int answer = 0;

        // 최대 시간을 뽑자
        long max = 0;
        for (int time : times) {
            if (max < time) {
                max = time;
            }
        }

        long start = 1, end = max * n;

        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;

            for (int time : times) {
                total += mid / time;
            }

            if (total >= n) {
                end = mid - 1;
                answer = (int) mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println("answer = " + answer);

    }
}
