package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class StoneRemoveTest {

    @Test
    public void stoneRemove() {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        int answer = 0;

        Arrays.sort(rocks);
        int start = 1, end = distance;
        while (start <= end) {
            int mid = (start + end) / 2;
            int cur = 0;
            int hits = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - cur < mid) {
                    hits++;
                } else {
                    cur = rocks[i];
                }
            }

            if (hits > n) {
                end = mid - 1;
                answer = end;
            } else {
                start = mid + 1;
            }
        }
        System.out.println("answer = " + answer);
    }

    @Test
    public void stoneRemove1() {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        int answer = 0;

        Arrays.sort(rocks);
        int start = 1, end = distance, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            int cur = 0;
            int hits = 0;

            for (int rock : rocks) {
                hits += mid / rock;
            }
            if (hits > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        answer = end;
        System.out.println("answer = " + answer);
    }
}
