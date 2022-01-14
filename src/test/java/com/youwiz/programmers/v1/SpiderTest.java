package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

@SpringBootTest
public class SpiderTest {

    @Test
    public void spiderTest() {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        int answer = 0;

        answer = Arrays.stream(clothes)
                .collect(
                        Collectors.groupingBy(p -> p[1],
                                Collectors.mapping(p -> p[0],
                                        Collectors.counting())))
                .values()
                .stream().reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;


        System.out.println("answer = " + answer);
    }

    @Test
    public void spiderTest1() {
//        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }

        System.out.println("answer = " + (answer - 1));
    }

    @Test
    public void spiderTest2() {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }

        for (int i = 0; i < clothes.length; i++) {
            answer *= (map.get(clothes[i][1]) + 1);
            map.put(clothes[i][1], 0);
        }

        System.out.println("(answer - 1) = " + (answer - 1));
    }
}
