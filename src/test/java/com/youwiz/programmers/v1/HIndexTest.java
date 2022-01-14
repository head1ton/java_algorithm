package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class HIndexTest {

    @Test
    public void hIndex() {
        int[] citations = {3, 0, 6, 1, 5};

        Arrays.sort(citations);

        int answer = 0;
        for (int i = citations.length - 1; i > -1; i--) {
            int min = (int)Math.min(citations[i], citations.length -i);
            if (answer < min) answer = min;
        }
        System.out.println("answer = " + answer);
    }

    @Test
    public void hIndex1() {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = 0;
        Arrays.sort(citations);                 // 0, 1, 3, 5, 6            5, 4, 3, 2, 1
        for (int i = 0; i < citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, smaller);
        }
        System.out.println("answer = " + answer);
    }

    @Test
    public void hIndex2() {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = 0;


        System.out.println("answer = " + answer);
    }
}
