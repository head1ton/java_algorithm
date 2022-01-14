package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class MaxNumberTest {

    @Test
    public void maxNumber() {
//        int[] numbers = {6, 10, 2};
        int[] numbers = {2, 10, 6};
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        // 10, 6    2, 10     2, 6
        Collections.sort(list, (x, y) -> {
            String as = String.valueOf(x), bs = String.valueOf(y);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if (answer.charAt(0) == '0') {
            answer = "0";
        }

        System.out.println("answer = " + answer);
    }

    @Test
    public void maxNumber1() {
        int[] numbers = {3, 30, 34, 5, 9};
        String answer = "";
        String[] num = new String[numbers.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = numbers[i] + "";
        }

        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (int i = 0; i < numbers.length; i++) {
            answer += num[i];
        }

        System.out.println("answer = " + answer);
    }
}
